#include "reservation.h"
#include <QSqlQuery>
#include <QtDebug>
#include <QString>
 #include <QDate>


int Reservation::getid_r()
{return id_r;}

int Reservation::getnbr_pr()
{return nbr_pr;}

int  Reservation::getnum_tel()
{return num_tel ;}



void Reservation::setid_r(int id_r)
{this->id_r=id_r;}
void Reservation::setnbr_pr (int nbr_pr)
{this->nbr_pr=nbr_pr;}
void Reservation::setnum_tel(int num_tel)
{this->num_tel=num_tel;}

Reservation::Reservation()
{}
Reservation :: Reservation (int id_r , int nbr_pr , int num_tel)
{this->id_r=id_r ;
 this->nbr_pr=nbr_pr ;
 this->num_tel=num_tel ;
 }

    bool Reservation::ajouter()
    {
        QSqlQuery query;

             query.prepare("INSERT INTO reservation (ID_R, NBR_PR, NUM_TEL) "
                           "VALUES (:id_r, :nbr_pr, :num_tel)");
             query.bindValue(":id_r", id_r);
             query.bindValue(":nbr_pr", nbr_pr);
             query.bindValue(":num_tel",num_tel );




    return query.exec();}

