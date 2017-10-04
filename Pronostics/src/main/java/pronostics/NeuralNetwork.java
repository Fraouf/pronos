/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pronostics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import sql.SQLConnection;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;

/**
 *
 * @author k1fryouf
 */
public class NeuralNetwork {
    
        MultilayerPerceptron mlp;
        ArrayList<Attribute> attributes;
        Instances dataSet;
        Instances testDataSet;
        SQLConnection conn;
        ArrayList<String> listNomEquipes;
        ArrayList<Equipe> listEquipes;
        WeightedTeams wTeams;
        
        public NeuralNetwork() throws IOException, Exception{
            
            conn = new SQLConnection();
            conn.createConnection();
            conn.setTableName("APP.EQUIPES");

            attributes = new ArrayList<>();
            listEquipes = conn.selectTeamsByComp("SP1");
            
            for(Equipe e : listEquipes){
                
                e.setHomeWeight(0);
                e.setAwayWeight(0);
                
            }
            
            wTeams = new WeightedTeams(listEquipes);
            
            //listEquipes.addAll(conn.selectTeamsByComp("SP2"));
            listNomEquipes = new ArrayList<>();
            ArrayList<String> results = new ArrayList<>();
            for(Equipe e : listEquipes){
                listNomEquipes.add(e.getNom());
            }
            //listNomEquipes = conn.selectTeamsByMatchs("");
            results.add("Home Win");
            results.add("Draw");
            results.add("Away Win");

            attributes.add(new Attribute("home_team", listNomEquipes));
            attributes.add(new Attribute("away_team", listNomEquipes));
            attributes.add(new Attribute("Result", results));

            dataSet = new Instances("ESDN", attributes, 0);

            conn.setTableName("APP.MATCHES");
            ArrayList<Match> listMatchs = conn.selectMatchsByComp("SP1");
            //listMatchs.addAll(conn.selectMatchsByComp("SP"));
            wTeams.setListMatchs(listMatchs);
            
            wTeams.ponder();
            wTeams.sort();
            wTeams.print();

            for(Match m : listMatchs){
                double[] values;
                values = new double[dataSet.numAttributes()]; 
                if(listNomEquipes.contains(m.getEquipeDom()) && listNomEquipes.contains(m.getEquipeExt())){
                    values[0] = listNomEquipes.indexOf(m.getEquipeDom());
                    values[1] = listNomEquipes.indexOf(m.getEquipeExt());
                    //System.out.println(m.toString());

                    if(m.getButDom()>m.getButExt()){
                        //System.out.println("home win");
                        values[2] = 0;
                    }else if(m.getButDom()<m.getButExt()){
                        //System.out.println("ayaw win");
                        values[2] = 2;
                    }else{
                        //System.out.println("draw");
                        values[2] = 1;
                    }


                    dataSet.add(new DenseInstance(1.0, values));
                }
            }

            dataSet.setClassIndex(dataSet.numAttributes()-1);
            //NonSparseToSparse nonSparseToSparseInstance = new NonSparseToSparse(); 
            //NominalToBinary ntb = new NominalToBinary();
            //ntb.setInputFormat(dataSet);
            //Instances filteredDataSet = Filter.useFilter(dataSet, ntb);
            //nonSparseToSparseInstance.setInputFormat(dataSet); 
            //Instances sparseDataset = Filter.useFilter(dataSet, nonSparseToSparseInstance);


            //System.out.println(dataSet);
            ArffSaver saver = new ArffSaver();
            saver.setInstances(dataSet);
            saver.setFile(new File("/Users/k1fryouf/Desktop/soccer.arff"));
            saver.writeBatch();

            mlp = new MultilayerPerceptron();
            mlp.setOptions(Utils.splitOptions("-L 0.3 -M 0.2 -N 500 -V 0 -S 0 -E 20 -H a"));

            mlp.buildClassifier(dataSet);

            Evaluation eval = new Evaluation(dataSet);
            eval.evaluateModel(mlp, dataSet);
            System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
            System.out.println(eval.toSummaryString()); //Summary of Training

            ConverterUtils.DataSource source1 = new ConverterUtils.DataSource("/Users/k1fryouf/Desktop/soccer-prediction.arff");
            testDataSet = source1.getDataSet();
            testDataSet.setClassIndex(testDataSet.numAttributes()-1);
            System.out.println("************************");
            System.out.println("Actual Class, Predicted Class");
            for(int i = 0; i < testDataSet.numInstances(); i++){
                double actualClass = testDataSet.instance(i).classValue();

                String actual = testDataSet.classAttribute().value((int) actualClass);

                Instance newInst = testDataSet.instance(i);

                double predInst = mlp.classifyInstance(newInst);

                String predString = testDataSet.classAttribute().value((int) predInst);

                System.out.println(actual+", "+predString);
            }
            
            Collections.sort(listEquipes, new Comparator<Equipe>() {
        @Override 
        public int compare(Equipe e1, Equipe e2) {
            if(e1.getHomeWeight() > e2.getAwayWeight()){
                return 1;
            }else if (e1.getHomeWeight() < e2.getAwayWeight()){
                return -1;
            }else{
                return 0;
            }
        }
        });
        }     

    public MultilayerPerceptron getMlp() {
        return mlp;
    }

    public void setMlp(MultilayerPerceptron mlp) {
        this.mlp = mlp;
    }

    public ArrayList<String> getListNomEquipes() {
        return listNomEquipes;
    }

    public void setListNomEquipes(ArrayList<String> listNomEquipes) {
        this.listNomEquipes = listNomEquipes;
    }

    public Instances getTestDataSet() {
        return testDataSet;
    }

    public void setTestDataSet(Instances testDataSet) {
        this.testDataSet = testDataSet;
    }
    
    public double classify(Instance i) throws Exception{
        Instances dataUnlabeled = new Instances("ESDN", attributes, 0);
        dataUnlabeled.add(i);
        dataUnlabeled.setClassIndex(dataUnlabeled.numAttributes() - 1); 
        return mlp.classifyInstance(dataUnlabeled.firstInstance());
    }
    public String instenseToString(double d){
        return testDataSet.classAttribute().value((int) d);
    }

    public WeightedTeams getwTeams() {
        return wTeams;
    }

    public void setwTeams(WeightedTeams wTeams) {
        this.wTeams = wTeams;
    }
    
    
}
