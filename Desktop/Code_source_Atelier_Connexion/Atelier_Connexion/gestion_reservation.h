#ifndef GESTION_RESERVATION_H
#define GESTION_RESERVATION_H

#include <QWidget>
#include "reservation.h"

namespace Ui {
class gestion_reservation;
}

class gestion_reservation : public QWidget
{
    Q_OBJECT

public:
    explicit gestion_reservation(QWidget *parent = nullptr);
    ~gestion_reservation();

private slots:
    void on_pb_ajout_reser_clicked();


    void on_tableview_currentChanged(int index);

    void on_pb_supp_r1_clicked();

    void on_pb_modifier_clicked();

private:
    Ui::gestion_reservation *ui;
    Reservation * reservation;
};

#endif // GESTION_RESERVATION_H
