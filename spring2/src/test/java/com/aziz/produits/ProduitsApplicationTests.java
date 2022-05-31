package com.aziz.produits;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.aziz.animateurs.entities.animateur;
import com.aziz.animateurs.entities.tv;
import com.aziz.animateurs.repos.AnimateurRepository;
import com.aziz.animateurs.service.AnimateurService;
@SpringBootTest
class ProduitsApplicationTests {

/*private AnimateurRepository animateurRepository;

@Autowired
private AnimateurService animateurService;

@Test
public void testCreateProduit() {
animateur prod = new animateur("PC Dell",2200.500,new Date());
animateurRepository.save(prod);
}
@Test
public void testFindProduit()
{
animateur p = animateurRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdateProduit()
{
animateur p = animateurRepository.findById(1L).get();
p.setPrixProduit(1000.0);
animateurRepository.save(p);
}
@Test
public void testDeleteProduit()
{
animateurRepository.deleteById(1L);;
}
 
@Test
public void testListerTousProduits()
{
List<animateur> prods = animateurRepository.findAll();
for (animateur p : prods)
{
System.out.println(p);
}
}
@Test
public void testFindByNomProduitContains()
{
Page<animateur> prods = animateurService.getAllProduitsParPage(0,2);
System.out.println(prods.getSize());
System.out.println(prods.getTotalElements());
System.out.println(prods.getTotalPages());
prods.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (animateur p : prods.getContent()
{
System.out.println(p);
} */
/*
@Test
public void testFindByNomProduit()
{
List<animateur> prods = animateurRepository.findByNomProduit("Clavier");
for (animateur p : prods)
{
System.out.println(p);
}
}
@Test
public void findByNomProduitContains()
{
List<animateur> prods=animateurRepository.findByNomProduitContains("P");
for (animateur p : prods)
{
System.out.println(p);
} }
@Test
public void testfindByNomPrix()
{
List<animateur> prods = animateurRepository.findByNomPrix("iphone X", 1000.0);
for (animateur p : prods)
{
System.out.println(p);
}
}

@Test
public void testfindByCategorie()
{
tv cat = new tv();
cat.setIdCat(1L);
List<animateur> prods = animateurRepository.findByCategorie(cat);
for (animateur p : prods)
{
System.out.println(p);
}
}
@Test
public void findByCategorieIdCat()
{
List<animateur> prods = animateurRepository.findByCategorieIdCat(1L);
for (animateur p : prods)
{
System.out.println(p);
}
 }
@Test
public void testfindByOrderByNomProduitAsc()
{
List<animateur> prods = 
animateurRepository.findByOrderByNomProduitAsc();
for (animateur p : prods)
{
System.out.println(p);
}
}
@Test
public void testTrierProduitsNomsPrix()
{
List<animateur> prods = animateurRepository.trierProduitsNomsPrix();
for (animateur p : prods)
{
System.out.println(p);
}
*/
}

