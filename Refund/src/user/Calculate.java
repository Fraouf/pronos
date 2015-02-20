/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author k1fryouf
 */
public class Calculate {

    public static void calculateTotalRefunds(User client) {

        for (int i = 0; i < client.getListReclam().size(); i++) {

            double remboursement = -1;

            switch (client.getContrat()) {

                case 'A':

                    remboursement = calculerCaseA(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());
                    break;

                case 'B':

                    remboursement = calculerCaseB(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());
                    break;

                case 'C':

                    remboursement = calculerCaseC(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());
                    break;

                case 'D':
                    
                    remboursement = calculerCaseD(client.getListReclam().get(i).getSoin(), client.getListReclam().get(i).getMontant());

            }
            
            client.getListRemb().get(i).setMontant(remboursement);
        }
    }

    public static Double calculerCaseA(int unSoin, Double unMontant) {

        Double remboursement = -1.00;

        if (unSoin >= 0 && unSoin <= 200 || unSoin == 500) {

            remboursement = unMontant * 0.25;

        } else if (unSoin >= 300 && unSoin <= 400 || unSoin == 700) {

            remboursement = unMontant * 0;

        } else if (unSoin == 600) {

            remboursement = unMontant * 0.40;

        }
        return remboursement;
    }

    public static Double calculerCaseB(int unSoin, Double unMontant) {

        Double remboursement = -1.00;

        if ((unSoin >= 0 && unSoin <= 100) || (unSoin >= 300 && unSoin <= 399) || unSoin == 500) {

            remboursement = unMontant * 0.50;

            if (unSoin == 0 && unMontant > 40) {

                remboursement = 40.00;

            } else if ((unSoin == 100 || unSoin == 500) && unMontant > 50) {

                remboursement = 50.00;
            }

        } else if (unSoin == 200 || unSoin == 600) {

            remboursement = unMontant;

            if (unSoin == 200 && unMontant > 70) {

                remboursement = 70.00;
            }

        } else if (unSoin == 600) {

            remboursement = unMontant * 0.40;
        }

        return remboursement;
    }

    public static Double calculerCaseC(int unSoin, Double unMontant) {

        Double remboursement;

        remboursement = unMontant * 0.90;

        return remboursement;
    }

    public static Double calculerCaseD(int unSoin, Double unMontant) {

        Double remboursement;

        remboursement = unMontant;

        if (unSoin == 0 && unMontant > 85) {

            remboursement = 85.00;

        } else if ((unSoin == 100 || unSoin == 500) && unMontant > 75) {

            remboursement = 75.00;

        } else if ((unSoin == 200 || unSoin == 600) && unMontant > 100) {

            remboursement = 100.00;

        } else if (unSoin == 400 && unMontant > 65) {

            remboursement = 65.00;

        } else if (unSoin == 700 && unMontant > 90) {

            remboursement = 90.00;
        }

        return remboursement;
    }
}
