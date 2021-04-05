#include "commande.h"
#include <QSqlQuery>
#include <QtDebug>
#include <QString>
 #include <QDate>
 #include <QObject>

int Commande ::getcode()
{return code;}
int Commande::getprix()
{return prix;}

int Commande::getadr()
{return adr;}

int Commande::getqt()
{return qt;}

int Commande::getnum_telc()
{return num_telc;}

QString Commande::getnom()
{return nom;}

QDate Commande::getdatc()
{return datc;}


void Commande::setcode(int code)
{this->code=code;}
void Commande::setprix(int prix)
{this->prix=prix;}
void Commande::setadr(int adr)
{this->adr=adr;}
void Commande::setqt(int qt)
{this->qt=qt;}
void Commande::setnum_telc(int num_telc)
{this->num_telc=num_telc;}
void Commande::setnom(QString nom)
{this->nom=nom;}
void Commande::setdatc(QDate datc)
{this->datc=datc;}

Commande::Commande()
{}
Commande :: Commande (int code , int prix , int adr,int qt ,int num_telc ,QString nom ,QDate datc)
{this->code=code ;
 this->prix=prix ;
 this->adr=adr ;
    this->qt=qt;
  this->num_telc=num_telc;
  this->nom=nom;
    this->datc=datc;

 }

    bool Commande::ajouter()
    {
        QSqlQuery query;

             query.prepare("INSERT INTO Commande (CODE, PRIX ,ADR,QT,NUM_TELC,NOM,DATC) "
                           "VALUES (:code, :prix,:adr,:qt ,:num_telc ,:nom ,:datc )");
             query.bindValue(":code", code);
             query.bindValue(":prix", prix);
              query.bindValue(":adr", adr);
               query.bindValue(":qt", qt);
             query.bindValue(":num_telc",num_telc );
              query.bindValue(":nom", nom);
             query.bindValue(":datc",datc );
        return query.exec();}

   QSqlQueryModel* Commande ::afficher_c()
    {
        QSqlQueryModel* model= new QSqlQueryModel();


              model->setQuery("SELECT* FROM commande");
              model->setHeaderData(0, Qt::Horizontal, QObject ::tr("code"));
              model->setHeaderData(1, Qt::Horizontal,QObject :: tr("prix"));
             model->setHeaderData(2, Qt::Horizontal,QObject :: tr("adr"));
               model->setHeaderData(3, Qt::Horizontal,QObject :: tr("qt"));
                 model->setHeaderData(4, Qt::Horizontal,QObject :: tr("num_telc"));
                   model->setHeaderData(5, Qt::Horizontal,QObject :: tr("nom"));
                     model->setHeaderData(6, Qt::Horizontal,QObject :: tr("dat"));


        return model;

    }
    bool Commande:: supprimer_c(int code)
{      QSqlQuery query;
        query.prepare("DELETE from commande where code=:code");
             query.bindValue(":code", code);

        return query.exec();}
    bool Commande:: modifier_co(int,int,int,int,int,QString,QDate)
    {

        QSqlQuery query;
        query.prepare("UPDATE commande set code=:code, prix=:prix, adr=:adr ,qt=:qt ,num_telc ,nom=:nom,datc=datc  WHERE code=:code");
        query.bindValue(":code",code);
        query.bindValue(":prix",prix);
        query.bindValue(":adr",adr);
        query.bindValue(":qt",qt);
        query.bindValue(":num_telc",num_telc);
        query.bindValue(":nom",nom);
        query.bindValue(":datc",datc);

        return query.exec();
    }
    /*bool Commande::trier_code(int code)

    {
        QSqlQueryModel* model = new QSqlQueryModel();
             model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
            model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
            model->setHeaderData(2, Qt::Horizontal, QObject::tr("adr"));
            model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
            model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
            model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
             model->setHeaderData(36, Qt::Horizontal, QObject::tr("datc"));

            return model ;
   }
    bool Commande::trier_nom(QString nom)

    {
        QSqlQueryModel* model = new QSqlQueryModel();
            model->setQuery("SELECT * from COMMANDE ORDER BY nom");

            model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
            model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
            model->setHeaderData(2, Qt::Horizontal, QObject::tr("adr"));
            model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
            model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
            model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
             model->setHeaderData(36, Qt::Horizontal, QObject::tr("datc"));

            return model ;
    }

   bool Commande::trier_prix(int prix)
    {
        QSqlQueryModel* model = new QSqlQueryModel();
            model->setQuery("SELECT * from Reservation ORDER BY prix");
      model->setHeaderData(0, Qt::Horizontal, QObject::tr("code"));
            model->setHeaderData(1, Qt::Horizontal, QObject::tr("prix"));
            model->setHeaderData(2, Qt::Horizontal, QObject::tr("adr"));
            model->setHeaderData(3, Qt::Horizontal, QObject::tr("qt"));
            model->setHeaderData(4, Qt::Horizontal, QObject::tr("num_telc"));
            model->setHeaderData(5, Qt::Horizontal, QObject::tr("nom"));
             model->setHeaderData(36, Qt::Horizontal, QObject::tr("datc"));

            return model ;
    }*/
