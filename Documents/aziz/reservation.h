#ifndef RESERVATION_H
#define RESERVATION_H
#include <QDate>
class Reservation
{
public:
    Reservation();
     Reservation(int id_r , int nbr_pr , int num_tel);
     int getid_r();
     int getnbr_pr();
     int getnum_tel();

     void setid_r(int);
     void setnbr_pr (int);
     void setnum_tel(int);

     bool ajouter();


private:
    int id_r;
    int nbr_pr ;
    int num_tel;


};

#endif // RESERVATION_H
