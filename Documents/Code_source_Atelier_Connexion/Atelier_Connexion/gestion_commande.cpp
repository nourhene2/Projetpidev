#include "gestion_commande.h"
#include "ui_gestion_commande.h"
#include<QMessageBox>
#include "commande.h"
gestion_commande::gestion_commande(QWidget *parent) :
    QWidget(parent),
    ui(new Ui::gestion_commande)
{
    ui->setupUi(this);
    this->setWindowTitle("Gestion des commandes");
}

gestion_commande::~gestion_commande()
{
    delete ui;
}

void gestion_commande::on_pb_ajout_c_clicked()
{
    int code=ui->code->text().toInt();
    int prix =ui->prix->text().toInt();
    int  adr=ui->adr->text().toInt();
    int qt =ui->qt->text().toInt();
    int  num_telc=ui->num_telc->text().toInt();
    QString  nom=ui->nom->text();
    QDate date =ui->datec->date();
   Commande c;
      c=  Commande(code, prix, adr, qt, num_telc, nom, date);
      bool test=c.ajouter();

      if(test) {
          QMessageBox::information(nullptr, QObject::tr("database is open"),
                                     QObject::tr("commande ajoutée !\n"
                          "click ok to exit"),QMessageBox::Ok);

      }
  else{QMessageBox::information(nullptr, QObject::tr("database is open"),
                                QObject::tr("erreur d'ajout !\n"
                     "click ok to exit"),QMessageBox::Ok);}

}





void gestion_commande::on_pb_modifier_c_clicked()
{
       int code=ui->code_m_2->text().toInt();
        int prix =ui->prix_m->text().toInt();
        int  adr=ui->adr_m->text().toInt();
        int qt=ui->qt_m->text().toInt();
        int  num_telc=ui->num_telc_m->text().toInt();
        QString  nom=ui->nom_m->text();
        QDate dat =ui->datc_m->date();
        Commande c;
        c=Commande(code,prix,adr,qt,num_telc,nom,dat);
         bool test=c.modifier_co(code,prix,adr,qt,num_telc,nom,dat);
    if(test) {
            QMessageBox::information(nullptr,"Modifier une commande","la commande a été modifié avec succès !");
        }
        else {
            QMessageBox::information(nullptr,"Modifier un menu ","Modification échouée !");

        }
    }


/*void gestion_commande::on_tableview_currentChanged(int index)
{
    ui->tab_c->setModel(commande->afficher_c());*/


void gestion_commande::on_pb_supp_c_clicked()
{
    int code = ui->code_supp->text().toInt();
    bool test =commande->supprimer_c(code);

    if(test) {
        QMessageBox::information(nullptr,"Supprimer une commande","la commande a été supprimée avec succès !");//Qwidget ==> les composants mt3 qt dima initliasation ta3 ay QWidget heya nullptr manha maytpointa ala chay
    }
    else {
        QMessageBox::information(nullptr,"Supprimer une commande","suppression échouée !");//Qwidget ==> les composants mt3 qt dima initliasation ta3 ay QWidget heya nullptr;

}}


