<?php

namespace App\Controller;


use  App\Entity\Lignedecommande;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use App\Form\LignedecommandeType;
use Symfony\Component\Routing\Annotation\Route;


class LignedecommandeController extends AbstractController
{
    /**
     * @Route("/lignedecommande", name="app_lignedecommande")
     */
    public function index(): Response
    {
        return $this->render('lignedecommande/index.html.twig', [
            'controller_name' => 'LignedecommandeController',
        ]);
    }
    /**
     * @Route("/listLignedecommande", name="listLignedecommande")
     */
    public function listLignedecommande()
    {
        $Lignedecommandes = $this->getDoctrine()->getRepository(Lignedecommande::class)->findAll();
        
        return $this->render('Lignedecommande/list.html.twig', ["Lignedecommandes" => $Lignedecommandes]);
    }

       /**
     * @Route("/addLignedecommande", name="addLignedecommande")
     */
    public function addLignedecommande(Request $request)
    {
        $lignedecommande = new Lignedecommande();
        $form = $this->createForm(LignedecommandeType::class, $lignedecommande);
        $form->add("Ajouter", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $em = $this->getDoctrine()->getManager();
            //$lignedecommande->setMoyenne(0);
            $em->persist($lignedecommande);
            $em->flush();
            return $this->redirectToRoute('listLignedecommande');
        }
        return $this->render("lignedecommande/add.html.twig", array('form' => $form->createView()));
    }
   /**
     * @Route("/deletel/{id}", name="deletelignedecommande")
     */
    public function deleteLignedecommande($id)
    {
        $lignedecommande = $this->getDoctrine()->getRepository(Lignedecommande::class)->find($id);
        dump($lignedecommande);
     $em = $this->getDoctrine()->getManager();
    $em->remove($lignedecommande);
      $em->flush();
       return $this->redirectToRoute("listLignedecommande");
    }
    /**
     * @Route("/updatel/{id}", name="updatelignedecommande")
     */
    public function updateLignedecommande(Request $request, $id)
    {
        $lignedecommande = $this->getDoctrine()->getRepository(Lignedecommande::class)->find($id);
        $form = $this->createForm(LignedecommandeType::class, $lignedecommande);
        $form->add("Modifier", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute('listLignedecommande');
        }
        return $this->render("lignedecommande/update.html.twig", array('form' => $form->createView()));
    }

}
