<?php

namespace App\Controller;
use  App\Entity\Commande;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use App\Form\CommandeType;
use Symfony\Component\Routing\Annotation\Route;

class CommandeController extends AbstractController
{
    /**
     * @Route("/commande", name="app_commande")
     */
    public function index(): Response
    {
        return $this->render('commande/index.html.twig', [
            'controller_name' => 'CommandeController',
        ]);
    }

    /**
     * @Route("/listCommande", name="listCommande")
     */
    public function listCommande()
    {
        $Commandes = $this->getDoctrine()->getRepository(Commande::class)->findAll();
        
        return $this->render('Commande/list.html.twig', ["Commandes" => $Commandes]);
    }

       /**
     * @Route("/addCommande", name="addCommande")
     */
    public function addCommande(Request $request)
    {
        $commande = new Commande();
        $form = $this->createForm(CommandeType::class, $commande);
        $form->add("Ajouter", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $em = $this->getDoctrine()->getManager();
            //$commande->setMoyenne(0);
            $em->persist($commande);
            $em->flush();
            return $this->redirectToRoute('listCommande');
        }
        return $this->render("commande/add.html.twig", array('form' => $form->createView()));
    }
   /**
     * @Route("/delete/{idc}", name="deleteCommande")
     */
    public function deleteCommande($idc)
    {
        $commande = $this->getDoctrine()->getRepository(Commande::class)->find($idc);
        $em = $this->getDoctrine()->getManager();
        $em->remove($commande);
        $em->flush();
        return $this->redirectToRoute("listCommande");
    }
    /**
     * @Route("/update/{idc}", name="updateCommande")
     */
    public function updateCommande(Request $request, $idc)
    {
        $commande = $this->getDoctrine()->getRepository(Commande::class)->find($idc);
        $form = $this->createForm(CommandeType::class, $commande);
        $form->add("Modifier", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute('listCommande');
        }
        return $this->render("commande/update.html.twig", array('form' => $form->createView()));
    }

}
