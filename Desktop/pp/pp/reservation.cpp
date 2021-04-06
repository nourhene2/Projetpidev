#include "reservation.h"
#include  <QSqlQuery>
#include <QtDebug>
#include<QObject>

int reservation::getid_r(){return id_r;}
int reservation::getnum_tel(){return num_tel;}
int reservation::getnbr_pr(){return nbr_pr;}
QDate reservation::getdat(){return dat;}
void reservation::setid_r(int id_r){this->id_r=id_r;}

void reservation::setnum_tel(int num_tel){this->num_tel=num_tel;}
void reservation::setnbr_pr(int nbr_pr){this->nbr_pr=nbr_pr;}
void reservation::setdat(QDate dat){this->dat=dat;}
reservation::reservation()
{}

reservation::reservation(int id_r,int num_tel,int nbr_pr,QDate dat)
{
   this->id_r=id_r;
 this->num_tel=num_tel;
 this->nbr_pr=nbr_pr;
   this->dat=dat;


}
bool reservation::ajouter()
{
    QSqlQuery query;

         query.prepare("INSERT INTO reservation (ID_R, NUM_TEL, NBR_PR,DAT) "
                       "VALUES (:id_r, :num_tel, :nbr_pr, :dat)");
         query.bindValue(":id_r", id_r);
         query.bindValue(":num_tel", num_tel);
         query.bindValue(":nbr_pr", nbr_pr);
         query.bindValue(":dat",dat);


    return query.exec();
}
bool reservation::supprimer(int id_r)
{
     QSqlQuery query;
    query.prepare("Delete from reservation where id_r=:id_r");
    query.bindValue(":id_r", id_r);

   return query.exec();
}
QSqlQueryModel* reservation::afficher()
{
    QSqlQueryModel* model=new QSqlQueryModel();

          model->setQuery("SELECT* FROM reservation");
          model->setHeaderData(0, Qt::Horizontal, QObject::tr("id_r"));
          model->setHeaderData(1, Qt::Horizontal, QObject::tr("num_tel"));
          model->setHeaderData(2, Qt::Horizontal, QObject::tr("nbr_pr"));
           model->setHeaderData(3, Qt::Horizontal, QObject::tr("dat"));



    return model;
}
bool reservation::modifier(int id_r,int num_tel,int nbr_pr,QDate dat)
{

    QSqlQuery query;
    query.prepare("UPDATE  reservation set id_r=:id_r,num_tel=:num_tel, nbr_pr=:nbr_pr,dat=:dat  WHERE id_r=:id_r");
    query.bindValue(":id_r", id_r);
    query.bindValue(":num_tel", num_tel);
    query.bindValue(":nbr_pr", nbr_pr);
    query.bindValue(":dat",dat);

    return query.exec();
}




