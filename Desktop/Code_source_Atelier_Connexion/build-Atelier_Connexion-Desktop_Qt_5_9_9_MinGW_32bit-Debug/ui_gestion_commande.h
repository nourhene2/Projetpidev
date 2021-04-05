/********************************************************************************
** Form generated from reading UI file 'gestion_commande.ui'
**
** Created by: Qt User Interface Compiler version 5.9.9
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_GESTION_COMMANDE_H
#define UI_GESTION_COMMANDE_H

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

class Ui_gestion_commande
{
public:
    QTabWidget *code_m;
    QWidget *tab_4;
    QLineEdit *code;
    QLineEdit *adr;
    QLineEdit *qt;
    QLabel *label_11;
    QLabel *label_13;
    QLabel *label_14;
    QLabel *label_15;
    QLabel *label_17;
    QPushButton *pb_ajout_c;
    QDateTimeEdit *datec;
    QLineEdit *prix;
    QLineEdit *num_telc;
    QLineEdit *nom;
    QLabel *label_16;
    QLabel *label_19;
    QWidget *tab_5;
    QLabel *label_18;
    QPushButton *pb_modifier_c;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QLabel *label_5;
    QLabel *label_6;
    QLabel *label_7;
    QLineEdit *code_m_2;
    QLineEdit *prix_m;
    QLineEdit *adr_m;
    QLineEdit *qt_m;
    QLineEdit *num_telc_m;
    QLineEdit *nom_m;
    QDateTimeEdit *datc_m;
    QWidget *supprimerunecommande;
    QPushButton *pb_supp_c;
    QLineEdit *code_supp;
    QWidget *tab_6;
    QTableView *tab_c;

    void setupUi(QWidget *gestion_commande)
    {
        if (gestion_commande->objectName().isEmpty())
            gestion_commande->setObjectName(QStringLiteral("gestion_commande"));
        gestion_commande->resize(756, 384);
        code_m = new QTabWidget(gestion_commande);
        code_m->setObjectName(QStringLiteral("code_m"));
        code_m->setGeometry(QRect(20, 20, 631, 321));
        tab_4 = new QWidget();
        tab_4->setObjectName(QStringLiteral("tab_4"));
        code = new QLineEdit(tab_4);
        code->setObjectName(QStringLiteral("code"));
        code->setGeometry(QRect(200, 10, 113, 20));
        adr = new QLineEdit(tab_4);
        adr->setObjectName(QStringLiteral("adr"));
        adr->setGeometry(QRect(200, 90, 113, 20));
        qt = new QLineEdit(tab_4);
        qt->setObjectName(QStringLiteral("qt"));
        qt->setGeometry(QRect(200, 130, 113, 20));
        label_11 = new QLabel(tab_4);
        label_11->setObjectName(QStringLiteral("label_11"));
        label_11->setGeometry(QRect(70, 20, 101, 21));
        label_13 = new QLabel(tab_4);
        label_13->setObjectName(QStringLiteral("label_13"));
        label_13->setGeometry(QRect(60, 130, 101, 20));
        label_14 = new QLabel(tab_4);
        label_14->setObjectName(QStringLiteral("label_14"));
        label_14->setGeometry(QRect(60, 90, 91, 16));
        label_15 = new QLabel(tab_4);
        label_15->setObjectName(QStringLiteral("label_15"));
        label_15->setGeometry(QRect(40, 170, 171, 21));
        label_17 = new QLabel(tab_4);
        label_17->setObjectName(QStringLiteral("label_17"));
        label_17->setGeometry(QRect(50, 250, 121, 20));
        pb_ajout_c = new QPushButton(tab_4);
        pb_ajout_c->setObjectName(QStringLiteral("pb_ajout_c"));
        pb_ajout_c->setGeometry(QRect(420, 100, 121, 61));
        datec = new QDateTimeEdit(tab_4);
        datec->setObjectName(QStringLiteral("datec"));
        datec->setGeometry(QRect(200, 250, 194, 22));
        prix = new QLineEdit(tab_4);
        prix->setObjectName(QStringLiteral("prix"));
        prix->setGeometry(QRect(200, 50, 113, 20));
        num_telc = new QLineEdit(tab_4);
        num_telc->setObjectName(QStringLiteral("num_telc"));
        num_telc->setGeometry(QRect(200, 170, 113, 20));
        nom = new QLineEdit(tab_4);
        nom->setObjectName(QStringLiteral("nom"));
        nom->setGeometry(QRect(200, 210, 113, 20));
        label_16 = new QLabel(tab_4);
        label_16->setObjectName(QStringLiteral("label_16"));
        label_16->setGeometry(QRect(70, 50, 71, 21));
        label_19 = new QLabel(tab_4);
        label_19->setObjectName(QStringLiteral("label_19"));
        label_19->setGeometry(QRect(70, 210, 101, 20));
        code_m->addTab(tab_4, QString());
        tab_5 = new QWidget();
        tab_5->setObjectName(QStringLiteral("tab_5"));
        label_18 = new QLabel(tab_5);
        label_18->setObjectName(QStringLiteral("label_18"));
        label_18->setGeometry(QRect(440, 60, 47, 13));
        pb_modifier_c = new QPushButton(tab_5);
        pb_modifier_c->setObjectName(QStringLiteral("pb_modifier_c"));
        pb_modifier_c->setGeometry(QRect(370, 120, 121, 31));
        label = new QLabel(tab_5);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(80, 20, 47, 13));
        label_2 = new QLabel(tab_5);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(80, 60, 47, 13));
        label_3 = new QLabel(tab_5);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(80, 100, 47, 13));
        label_4 = new QLabel(tab_5);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setGeometry(QRect(80, 130, 47, 13));
        label_5 = new QLabel(tab_5);
        label_5->setObjectName(QStringLiteral("label_5"));
        label_5->setGeometry(QRect(80, 170, 47, 13));
        label_6 = new QLabel(tab_5);
        label_6->setObjectName(QStringLiteral("label_6"));
        label_6->setGeometry(QRect(80, 200, 47, 13));
        label_7 = new QLabel(tab_5);
        label_7->setObjectName(QStringLiteral("label_7"));
        label_7->setGeometry(QRect(36, 230, 91, 20));
        code_m_2 = new QLineEdit(tab_5);
        code_m_2->setObjectName(QStringLiteral("code_m_2"));
        code_m_2->setGeometry(QRect(170, 10, 113, 20));
        prix_m = new QLineEdit(tab_5);
        prix_m->setObjectName(QStringLiteral("prix_m"));
        prix_m->setGeometry(QRect(160, 50, 113, 20));
        adr_m = new QLineEdit(tab_5);
        adr_m->setObjectName(QStringLiteral("adr_m"));
        adr_m->setGeometry(QRect(170, 90, 113, 20));
        qt_m = new QLineEdit(tab_5);
        qt_m->setObjectName(QStringLiteral("qt_m"));
        qt_m->setGeometry(QRect(170, 130, 113, 20));
        num_telc_m = new QLineEdit(tab_5);
        num_telc_m->setObjectName(QStringLiteral("num_telc_m"));
        num_telc_m->setGeometry(QRect(170, 170, 113, 20));
        nom_m = new QLineEdit(tab_5);
        nom_m->setObjectName(QStringLiteral("nom_m"));
        nom_m->setGeometry(QRect(170, 200, 113, 20));
        datc_m = new QDateTimeEdit(tab_5);
        datc_m->setObjectName(QStringLiteral("datc_m"));
        datc_m->setGeometry(QRect(160, 230, 194, 22));
        code_m->addTab(tab_5, QString());
        supprimerunecommande = new QWidget();
        supprimerunecommande->setObjectName(QStringLiteral("supprimerunecommande"));
        pb_supp_c = new QPushButton(supprimerunecommande);
        pb_supp_c->setObjectName(QStringLiteral("pb_supp_c"));
        pb_supp_c->setGeometry(QRect(360, 80, 121, 31));
        code_supp = new QLineEdit(supprimerunecommande);
        code_supp->setObjectName(QStringLiteral("code_supp"));
        code_supp->setGeometry(QRect(100, 70, 113, 20));
        code_m->addTab(supprimerunecommande, QString());
        tab_6 = new QWidget();
        tab_6->setObjectName(QStringLiteral("tab_6"));
        tab_c = new QTableView(tab_6);
        tab_c->setObjectName(QStringLiteral("tab_c"));
        tab_c->setGeometry(QRect(20, 20, 531, 211));
        code_m->addTab(tab_6, QString());

        retranslateUi(gestion_commande);

        code_m->setCurrentIndex(1);


        QMetaObject::connectSlotsByName(gestion_commande);
    } // setupUi

    void retranslateUi(QWidget *gestion_commande)
    {
        gestion_commande->setWindowTitle(QApplication::translate("gestion_commande", "Form", Q_NULLPTR));
        label_11->setText(QApplication::translate("gestion_commande", "saisir le code", Q_NULLPTR));
        label_13->setText(QApplication::translate("gestion_commande", "saisir la quantit\303\251", Q_NULLPTR));
        label_14->setText(QApplication::translate("gestion_commande", "saisir l'adresse", Q_NULLPTR));
        label_15->setText(QApplication::translate("gestion_commande", "saisir le num\303\251ro de telephone", Q_NULLPTR));
        label_17->setText(QApplication::translate("gestion_commande", "saisir la date commande", Q_NULLPTR));
        pb_ajout_c->setText(QApplication::translate("gestion_commande", "ajouter commande", Q_NULLPTR));
        label_16->setText(QApplication::translate("gestion_commande", "saisir le prix", Q_NULLPTR));
        label_19->setText(QApplication::translate("gestion_commande", "saisir le nom", Q_NULLPTR));
        code_m->setTabText(code_m->indexOf(tab_4), QApplication::translate("gestion_commande", "Ajouter une commande", Q_NULLPTR));
        label_18->setText(QString());
        pb_modifier_c->setText(QApplication::translate("gestion_commande", "modifier commande", Q_NULLPTR));
        label->setText(QApplication::translate("gestion_commande", "code", Q_NULLPTR));
        label_2->setText(QApplication::translate("gestion_commande", "prix", Q_NULLPTR));
        label_3->setText(QApplication::translate("gestion_commande", "adr", Q_NULLPTR));
        label_4->setText(QApplication::translate("gestion_commande", "qt", Q_NULLPTR));
        label_5->setText(QApplication::translate("gestion_commande", "num_telc", Q_NULLPTR));
        label_6->setText(QApplication::translate("gestion_commande", "nom", Q_NULLPTR));
        label_7->setText(QApplication::translate("gestion_commande", "cate_commande", Q_NULLPTR));
        code_m->setTabText(code_m->indexOf(tab_5), QApplication::translate("gestion_commande", "modifier une commande", Q_NULLPTR));
        pb_supp_c->setText(QApplication::translate("gestion_commande", "supprimer commande", Q_NULLPTR));
        code_m->setTabText(code_m->indexOf(supprimerunecommande), QApplication::translate("gestion_commande", "supprimer une commande", Q_NULLPTR));
        code_m->setTabText(code_m->indexOf(tab_6), QApplication::translate("gestion_commande", "afficher une commande", Q_NULLPTR));
    } // retranslateUi

};

namespace Ui {
    class gestion_commande: public Ui_gestion_commande {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_GESTION_COMMANDE_H
