/********************************************************************************
** Form generated from reading UI file 'gestion_reservation.ui'
**
** Created by: Qt User Interface Compiler version 5.9.9
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_GESTION_RESERVATION_H
#define UI_GESTION_RESERVATION_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QDateTimeEdit>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QTableView>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_gestion_reservation
{
public:
    QTabWidget *id_r;
    QWidget *tab_4;
    QLineEdit *le_id;
    QLineEdit *nbr_pr;
    QLineEdit *num_tel;
    QLabel *label_11;
    QLabel *label_12;
    QLabel *label_13;
    QLabel *label_14;
    QLabel *label_15;
    QLabel *label_17;
    QPushButton *pb_ajout_reser;
    QDateTimeEdit *dat;
    QWidget *supprimerunecommande;
    QPushButton *pb_supp_r1;
    QLineEdit *id_supp;
    QWidget *tab_5;
    QLabel *label_18;
    QDateTimeEdit *dat_m;
    QLineEdit *id_r_m;
    QLineEdit *num_tel_m;
    QLineEdit *nbr_pr_m;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_6;
    QLabel *label_7;
    QPushButton *pb_modifier;
    QWidget *tab_6;
    QTableView *tab_c;

    void setupUi(QWidget *gestion_reservation)
    {
        if (gestion_reservation->objectName().isEmpty())
            gestion_reservation->setObjectName(QStringLiteral("gestion_reservation"));
        gestion_reservation->resize(735, 378);
        id_r = new QTabWidget(gestion_reservation);
        id_r->setObjectName(QStringLiteral("id_r"));
        id_r->setGeometry(QRect(40, 30, 581, 281));
        tab_4 = new QWidget();
        tab_4->setObjectName(QStringLiteral("tab_4"));
        le_id = new QLineEdit(tab_4);
        le_id->setObjectName(QStringLiteral("le_id"));
        le_id->setGeometry(QRect(200, 10, 113, 20));
        nbr_pr = new QLineEdit(tab_4);
        nbr_pr->setObjectName(QStringLiteral("nbr_pr"));
        nbr_pr->setGeometry(QRect(220, 60, 113, 20));
        num_tel = new QLineEdit(tab_4);
        num_tel->setObjectName(QStringLiteral("num_tel"));
        num_tel->setGeometry(QRect(210, 100, 113, 20));
        label_11 = new QLabel(tab_4);
        label_11->setObjectName(QStringLiteral("label_11"));
        label_11->setGeometry(QRect(80, 10, 47, 13));
        label_12 = new QLabel(tab_4);
        label_12->setObjectName(QStringLiteral("label_12"));
        label_12->setGeometry(QRect(80, 70, 47, 13));
        label_13 = new QLabel(tab_4);
        label_13->setObjectName(QStringLiteral("label_13"));
        label_13->setGeometry(QRect(80, 110, 47, 13));
        label_14 = new QLabel(tab_4);
        label_14->setObjectName(QStringLiteral("label_14"));
        label_14->setGeometry(QRect(80, 100, 47, 13));
        label_15 = new QLabel(tab_4);
        label_15->setObjectName(QStringLiteral("label_15"));
        label_15->setGeometry(QRect(80, 130, 47, 13));
        label_17 = new QLabel(tab_4);
        label_17->setObjectName(QStringLiteral("label_17"));
        label_17->setGeometry(QRect(50, 140, 121, 20));
        pb_ajout_reser = new QPushButton(tab_4);
        pb_ajout_reser->setObjectName(QStringLiteral("pb_ajout_reser"));
        pb_ajout_reser->setGeometry(QRect(420, 140, 121, 31));
        dat = new QDateTimeEdit(tab_4);
        dat->setObjectName(QStringLiteral("dat"));
        dat->setGeometry(QRect(170, 140, 194, 22));
        id_r->addTab(tab_4, QString());
        supprimerunecommande = new QWidget();
        supprimerunecommande->setObjectName(QStringLiteral("supprimerunecommande"));
        pb_supp_r1 = new QPushButton(supprimerunecommande);
        pb_supp_r1->setObjectName(QStringLiteral("pb_supp_r1"));
        pb_supp_r1->setGeometry(QRect(340, 80, 141, 51));
        id_supp = new QLineEdit(supprimerunecommande);
        id_supp->setObjectName(QStringLiteral("id_supp"));
        id_supp->setGeometry(QRect(130, 90, 113, 20));
        id_r->addTab(supprimerunecommande, QString());
        tab_5 = new QWidget();
        tab_5->setObjectName(QStringLiteral("tab_5"));
        label_18 = new QLabel(tab_5);
        label_18->setObjectName(QStringLiteral("label_18"));
        label_18->setGeometry(QRect(440, 60, 47, 13));
        dat_m = new QDateTimeEdit(tab_5);
        dat_m->setObjectName(QStringLiteral("dat_m"));
        dat_m->setGeometry(QRect(200, 220, 194, 22));
        id_r_m = new QLineEdit(tab_5);
        id_r_m->setObjectName(QStringLiteral("id_r_m"));
        id_r_m->setGeometry(QRect(220, 10, 113, 20));
        num_tel_m = new QLineEdit(tab_5);
        num_tel_m->setObjectName(QStringLiteral("num_tel_m"));
        num_tel_m->setGeometry(QRect(220, 40, 113, 20));
        nbr_pr_m = new QLineEdit(tab_5);
        nbr_pr_m->setObjectName(QStringLiteral("nbr_pr_m"));
        nbr_pr_m->setGeometry(QRect(220, 70, 113, 20));
        label = new QLabel(tab_5);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(110, 10, 47, 13));
        label_2 = new QLabel(tab_5);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(110, 40, 47, 13));
        label_3 = new QLabel(tab_5);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(110, 80, 47, 13));
        label_6 = new QLabel(tab_5);
        label_6->setObjectName(QStringLiteral("label_6"));
        label_6->setGeometry(QRect(120, 190, 47, 13));
        label_7 = new QLabel(tab_5);
        label_7->setObjectName(QStringLiteral("label_7"));
        label_7->setGeometry(QRect(110, 230, 47, 13));
        pb_modifier = new QPushButton(tab_5);
        pb_modifier->setObjectName(QStringLiteral("pb_modifier"));
        pb_modifier->setGeometry(QRect(410, 120, 151, 61));
        id_r->addTab(tab_5, QString());
        tab_6 = new QWidget();
        tab_6->setObjectName(QStringLiteral("tab_6"));
        tab_c = new QTableView(tab_6);
        tab_c->setObjectName(QStringLiteral("tab_c"));
        tab_c->setGeometry(QRect(20, 20, 531, 211));
        id_r->addTab(tab_6, QString());

        retranslateUi(gestion_reservation);

        id_r->setCurrentIndex(1);


        QMetaObject::connectSlotsByName(gestion_reservation);
    } // setupUi

    void retranslateUi(QWidget *gestion_reservation)
    {
        gestion_reservation->setWindowTitle(QApplication::translate("gestion_reservation", "Form", Q_NULLPTR));
        label_11->setText(QApplication::translate("gestion_reservation", "id_r", Q_NULLPTR));
        label_12->setText(QApplication::translate("gestion_reservation", "nbr_pr", Q_NULLPTR));
        label_13->setText(QApplication::translate("gestion_reservation", "num_tel", Q_NULLPTR));
        label_14->setText(QString());
        label_15->setText(QString());
        label_17->setText(QApplication::translate("gestion_reservation", "date reservation", Q_NULLPTR));
        pb_ajout_reser->setText(QApplication::translate("gestion_reservation", "ajouter", Q_NULLPTR));
        id_r->setTabText(id_r->indexOf(tab_4), QApplication::translate("gestion_reservation", "Ajouter une  r\303\251servation", Q_NULLPTR));
        pb_supp_r1->setText(QApplication::translate("gestion_reservation", "supprimer reservation", Q_NULLPTR));
        id_r->setTabText(id_r->indexOf(supprimerunecommande), QApplication::translate("gestion_reservation", "supprimer une r\303\251servation", Q_NULLPTR));
        label_18->setText(QApplication::translate("gestion_reservation", "trie selon", Q_NULLPTR));
        label->setText(QApplication::translate("gestion_reservation", "id_r", Q_NULLPTR));
        label_2->setText(QApplication::translate("gestion_reservation", "num_tel", Q_NULLPTR));
        label_3->setText(QApplication::translate("gestion_reservation", "nbr_pr", Q_NULLPTR));
        label_6->setText(QString());
        label_7->setText(QApplication::translate("gestion_reservation", "date r", Q_NULLPTR));
        pb_modifier->setText(QApplication::translate("gestion_reservation", "modifier reservation", Q_NULLPTR));
        id_r->setTabText(id_r->indexOf(tab_5), QApplication::translate("gestion_reservation", "modifier une  r\303\251servation", Q_NULLPTR));
        id_r->setTabText(id_r->indexOf(tab_6), QApplication::translate("gestion_reservation", "afficher une  r\303\251servation", Q_NULLPTR));
    } // retranslateUi

};

namespace Ui {
    class gestion_reservation: public Ui_gestion_reservation {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_GESTION_RESERVATION_H
