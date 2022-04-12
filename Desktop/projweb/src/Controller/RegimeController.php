<?php

namespace App\Controller;

use  App\Entity\Regime;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use App\Form\RegimeType;
use Symfony\Component\Routing\Annotation\Route;

class RegimeController extends AbstractController
{
    /**
     * @Route("/regime", name="app_regime")
     */
    public function index(): Response
    {
        return $this->render('regime/index.html.twig', [
            'controller_name' => 'RegimeController',
        ]);
    }
    /**
     * @Route("/listRegime", name="listRegime")
     */
    public function listRegime()
    {
        $Regimes = $this->getDoctrine()->getRepository(Regime::class)->findAll();
        
        return $this->render('Regime/list.html.twig', ["Regimes" => $Regimes]);
    }

       /**
     * @Route("/addRegime", name="addRegime")
     */
    public function addRegime(Request $request)
    {
        $regime = new Regime();
        $form = $this->createForm(RegimeType::class, $regime);
        $form->add("Ajouter", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {

            $image = $form->get('image')->getData();
            $fichier = $regime->getCategorie() . '.' . $image->guessExtension();

            $image->move(
                $this->getParameter('images_directory'),
                $fichier
            );
           $regime->setImage($fichier);
            $em = $this->getDoctrine()->getManager();
            //$regime->setMoyenne(0);
            $em->persist($regime);
            $em->flush();
            return $this->redirectToRoute('listRegime');
            
        }
        return $this->render("regime/add.html.twig", array('form' => $form->createView()));
    }
    
   /**
     * @Route("/delete/{idR}", name="deleteRegime")
     */
    public function deleteRegime($idR)
    {
        $regime = $this->getDoctrine()->getRepository(Regime::class)->find($idR);
        $em = $this->getDoctrine()->getManager();
        $em->remove($regime);
        $em->flush();
        return $this->redirectToRoute("listRegime");
    }
    /**
     * @Route("/update/{idR}", name="updateRegime")
     */
    public function updateRegime(Request $request, $idR)
    {
        $regime = $this->getDoctrine()->getRepository(Regime::class)->find($idR);
        $form = $this->createForm(RegimeType::class, $regime);
        $form->add("Modifier", SubmitType::class);
        $form->handleRequest($request);
        if ($form->isSubmitted()) {
            $image = $form->get('image')->getData();
            $fichier = $regime->getCategorie() . '.' . $image->guessExtension();

            $image->move(
                $this->getParameter('images_directory'),
                $fichier
            );
           $regime->setImage($fichier);
            $em = $this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute('listRegime');
        }
        return $this->render("regime/update.html.twig", array('form' => $form->createView()));
    }
}
