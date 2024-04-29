"use client";
import { Template, ImageCard } from "@/components";
import { Image } from "@/resources/image/image.resource";
import { useImageService } from "@/resources/image/image.service";
import { useState } from "react";

export default function GaleriaPage() {
  const useService = useImageService();
  const [images, setImages] = useState<Image[]>([]);

  async function searchImages() {
    const result = await useService.buscar();
    setImages(result);
    console.table(images);
  }

  function renderImageCard(image: Image) {
    return (
      <ImageCard
        nome={image.name}
        src={image.url}
        tamanho={image.size}
        dataUpload={image.uploadData}
      />
    );
  }

  function renderImageCards() {
    return images.map(renderImageCard);
  }

  return (
    <Template>
      <button className="bg-gay-500" onClick={searchImages}>
        Clique para mudar
      </button>
      <section className="grid grid-cols-3 gap-8">{renderImageCards()}</section>
    </Template>
  );
}
