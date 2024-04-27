import { Template, ImageCard } from "@/components";

export default function GaleriaPage() {
  return (
    <Template>
      <section className="grid grid-cols-3 gap-8">
        <ImageCard />
        <ImageCard />
        <ImageCard />
        <ImageCard />
      </section>
    </Template>
  );
}
