#ifndef RESERVATION_H
#define RESERVATION_H
#include <QDate>
#include <QSqlQueryModel>

class Reservation
{
public:
    Reservation();
     Reservation(int id_r , int nbr_pr , int num_tel, QDate dat);
     int getid_r();
     int getnbr_pr();
     int getnum_tel();
     QDate getdat();

     void setid_r(int);
     void setnbr_pr (int);
     void setnum_tel(int);
     void setdat(QDate);
     bool ajouter();
    QSqlQueryModel* afficher();
     bool supprimer(int);
     bool modifier();
     bool recherche(int);


private:
    int id_r;
    int nbr_pr ;
    int num_tel;
    QDate dat;


};

#endif // RESERVATION_H
