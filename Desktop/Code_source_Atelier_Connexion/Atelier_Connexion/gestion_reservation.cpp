#include "gestion_reservation.h"
#include "ui_gestion_reservation.h"
#include <QMessageBox>
#include "reservation.h"

gestion_reservation::gestion_reservation(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::gestion_reservation)
{
    ui->setupUi(this);
    this->setWindowTitle("Gestion des réservations");
}

gestion_reservation::~gestion_reservation()
{
    delete ui;
}




void gestion_reservation::on_pb_ajout_reser_clicked()
{
      int id_reservation=ui->le_id->text().toInt();
      int nbr_de_personne=ui->nbr_pr->text().toInt();
      int num_tel_reservation=ui->num_tel->text().toInt();
      QDate date =ui->dat->date();
      Reservation r;
        r= Reservation(id_reservation,id_reservation,num_tel_reservation,date);
        bool test=r.ajouter();

        if(test) {
            QMessageBox::information(nullptr, QObject::tr("database is open"),
                                       QObject::tr("Réservation ajoutée !\n"
                            "click ok to exit"),QMessageBox::Ok);

        }
    else{QMessageBox::information(nullptr, QObject::tr("database is open"),
                                  QObject::tr("erreur d'ajout !\n"
                       "click ok to exit"),QMessageBox::Ok);}


}



/*void gestion_reservation::on_tableview_currentChanged(int index)
{
    ui->tab_c->setModel(reservation->afficher());
}*/

void gestion_reservation::on_pb_supp_r1_clicked()
{
    int id_r= ui->id_supp->text().toInt();
    bool test=reservation->supprimer(id_r);

    if(test) {
        QMessageBox::information(nullptr,"Supprimer une réservation","la reservation a été supprimée avec succès !");//Qwidget ==> les composants mt3 qt dima initliasation ta3 ay QWidget heya nullptr manha maytpointa ala chay
    }
    else {
        QMessageBox::information(nullptr,"Supprimer une réservation ","suppression échouée !");//Qwidget ==> les composants mt3 qt dima initliasation ta3 ay QWidget heya nullptr;

    }
}

void gestion_reservation::on_pb_modifier_clicked()
{
    int id = ui->id_r_m->text().toInt();
    int nbr_pr = ui->nbr_pr_m->text().toInt();
   int num_tel = ui->num_tel_m->text().toInt();
    QDate dat= ui->dat_m->date();
    Reservation r ;
    r =  Reservation(id,nbr_pr,num_tel,dat);
    bool  test = r.modifier();
    if(test) {
        QMessageBox::information(nullptr,"Modifier un menu","le menu a été modifié avec succès !");
    }
    else {
        QMessageBox::information(nullptr,"Modifier un menu ","Modification échouée !");

    }
}
