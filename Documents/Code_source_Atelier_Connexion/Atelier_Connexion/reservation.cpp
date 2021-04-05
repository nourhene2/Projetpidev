#include "reservation.h"
#include <QSqlQuery>
#include <QtDebug>
#include <QString>
 #include <QDate>
 #include <QObject>

int Reservation::getid_r()
{return id_r;}

int Reservation::getnbr_pr()
{return nbr_pr;}

int  Reservation::getnum_tel()
{return num_tel ;}

QDate Reservation::getdat()
{return dat;}


void Reservation::setid_r(int id_r)
{this->id_r=id_r;}
void Reservation::setnbr_pr (int nbr_pr)
{this->nbr_pr=nbr_pr;}
void Reservation::setnum_tel(int num_tel)
{this->num_tel=num_tel;}
void Reservation::setdat(QDate dat)
{this->dat=dat;}
Reservation::Reservation()
{}
Reservation :: Reservation (int id_r , int nbr_pr , int num_tel, QDate dat)
{this->id_r=id_r ;
 this->nbr_pr=nbr_pr ;
 this->num_tel=num_tel ;
 this->dat=dat ;

 }

    bool Reservation::ajouter()
    {
        QSqlQuery query;

             query.prepare("INSERT INTO RESERVATION (id_r, nbr_pr, num_tel,dat)VALUES (:id_r, :nbr_pr, :num_tel , :dat )");
             query.bindValue(":id_r", id_r);
             query.bindValue(":nbr_pr", nbr_pr);
             query.bindValue(":num_tel",num_tel );
             query.bindValue(":dat",dat );
             return query.exec();}

  /* QSqlQueryModel* Reservation ::afficher()
    {
        QSqlQueryModel* model= new QSqlQueryModel();


              model->setQuery("SELECT* FROM RESERVATION");
              model->setHeaderData(0, Qt::Horizontal, QObject ::tr("lindentifiant"));
              model->setHeaderData(1, Qt::Horizontal,QObject :: tr("le nombres de personnes"));
              model->setHeaderData(2, Qt::Horizontal,QObject :: tr("numero de telephone"));
              model->setHeaderData(3, Qt::Horizontal,QObject :: tr("la date de resarvation"));



        return model;

    }*/
    bool Reservation::supprimer(int id_r)
{      QSqlQuery query;
        query.prepare("DELETE from Reservation where id_r=:id_r");
        QString i=QString::number(id_r);
        query.bindValue(":id_r", i);
        return query.exec();}

    bool Reservation::modifier() {
        QSqlQuery query;
        query.prepare("UPDATE RESERVATION  SET nbr_pr =:nbr_pr, num_tel =:num_tel ,date =:dat  WHERE id_r = :id_r");
        query.bindValue(":id_r",id_r);
        query.bindValue(":nbr_pr",nbr_pr);
        query.bindValue(":num_tel",num_tel);
        query.bindValue(":date",dat);
        return query.exec();

    }
