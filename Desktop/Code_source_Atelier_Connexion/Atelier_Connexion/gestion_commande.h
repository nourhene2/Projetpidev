#ifndef GESTION_COMMANDE_H
#define GESTION_COMMANDE_H

#include <QWidget>
#include "commande.h"

namespace Ui {
class gestion_commande;
}

class gestion_commande : public QWidget
{
    Q_OBJECT

public:
    explicit gestion_commande(QWidget *parent = nullptr);
    ~gestion_commande();

private slots:
   void on_pb_ajout_c_clicked();

    void on_pb_supp_c_clicked();

   void on_pb_modifier_c_clicked();


private:
    Ui::gestion_commande *ui;
    Commande * commande;
};

#endif // GESTION_COMMANDE_H
