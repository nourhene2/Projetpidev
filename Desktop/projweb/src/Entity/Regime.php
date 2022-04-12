<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Regime
 *
 * @ORM\Table(name="regime")
 * @ORM\Entity
 */
class Regime
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdR", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idr;

    /**
     * @var string
     *
     * @ORM\Column(name="Categorie", type="string", length=255, nullable=false)
     */
    private $categorie;

    /**
     * @var string
     *
     * @ORM\Column(name="Objectif", type="string", length=255, nullable=false)
     */
    private $objectif;

    /**
     * @var string
     *
     * @ORM\Column(name="Image", type="string", length=255, nullable=false)
     */
    private $image;

    public function getIdr(): ?int
    {
        return $this->idr;
    }

    public function getCategorie(): ?string
    {
        return $this->categorie;
    }

    public function setCategorie(string $categorie): self
    {
        $this->categorie = $categorie;

        return $this;
    }

    public function getObjectif(): ?string
    {
        return $this->objectif;
    }

    public function setObjectif(string $objectif): self
    {
        $this->objectif = $objectif;

        return $this;
    }

    public function getImage(): ?string
    {
        return $this->image;
    }

    public function setImage(string $image): self
    {
        $this->image = $image;

        return $this;
    }


}
