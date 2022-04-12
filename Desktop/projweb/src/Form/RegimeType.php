<?php

namespace App\Form;

use App\Entity\Regime;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\HttpFoundation\File\File;

use Symfony\Component\Form\Extension\Core\Type\ChoiceType;

class RegimeType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder->setAction($options['action'])
           // ->add(child:'categorie',type:ChoiceType::class,array('choices'=> array('a','b','c')))
           -> add('categorie', ChoiceType::class, [
                'choices'  => [
                    'strict' => 'strict',
                    'facile' => 'facile',
                    'moyen' => 'moyen',
                ],
            ])
            -> add('objectif', ChoiceType::class, [
                'choices'  => [
                    'gain de poids' => 'gain de poids',
                    'perte de poids' => 'perte de poids',
                    'garde de poids' => 'garde de poids',
                ],
            ])
            //->add('objectif')
            ->add('image', FileType::class, [
                'label' => false,
                'multiple' => false,
                'mapped' => false,
                'required' => false
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Regime::class,
        ]);
    }
}
