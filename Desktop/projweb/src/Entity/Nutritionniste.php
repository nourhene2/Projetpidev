<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Nutritionniste
 *
 * @ORM\Table(name="nutritionniste")
 * @ORM\Entity
 */
class Nutritionniste
{
    /**
     * @var int
     *
     * @ORM\Column(name="id_n", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idN;

    /**
     * @var string
     *
     * @ORM\Column(name="adr", type="string", length=255, nullable=false)
     */
    private $adr;

    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     */
    private $id;

    public function getIdN(): ?int
    {
        return $this->idN;
    }

    public function getAdr(): ?string
    {
        return $this->adr;
    }

    public function setAdr(string $adr): self
    {
        $this->adr = $adr;

        return $this;
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function setId(int $id): self
    {
        $this->id = $id;

        return $this;
    }


}
