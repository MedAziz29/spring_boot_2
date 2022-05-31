package com.aziz.animateurs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aziz.animateurs.entities.Role;
import com.aziz.animateurs.entities.User;
import com.aziz.animateurs.entities.animateur;
import com.aziz.animateurs.entities.tv;
import com.aziz.animateurs.service.TvService;
import com.aziz.animateurs.service.UsersService;
import com.aziz.animateurs.service.AnimateurService;
import com.aziz.animateurs.service.RoleService;
@Controller
public class AnimateurController {
@Autowired
AnimateurService animateurService;
@Autowired
TvService tvService;
@Autowired
UsersService usersService;
@Autowired
RoleService roleService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<tv> cats = tvService.findAll();
modelMap.addAttribute("categories", cats);
modelMap.addAttribute("animateurs", new animateur());
modelMap.addAttribute("mode", "new");
return "formAnimateur";
}
@RequestMapping("/saveAnimateur")
public String saveProduit(@Valid animateur animateur,
BindingResult bindingResult)
{
System.out.println(animateur);
if (bindingResult.hasErrors()) return "formProduit";
animateurService.saveAnimateur(animateur);

return "redirect:/ListeAnimateurs";
}

@RequestMapping("/showCreateTv")
public String showCreateCat(ModelMap modelMap)
{
modelMap.addAttribute("tvs", new tv());
modelMap.addAttribute("mode", "new");
return "formTv";
}
@RequestMapping("/saveTv")
public String saveCategorie(@ModelAttribute("tv") tv tv,ModelMap modelMap) throws ParseException 
{
tv saveCategorie = tvService.saveTv(tv);
return "redirect:/ListeTv";
}

@RequestMapping("/ListeTv")
public String listeProduits(ModelMap modelMap)
{
List <tv>tvs = tvService.findAll();
modelMap.addAttribute("tvs", tvs);
return "ListeTv";
}

@RequestMapping("/ListeAnimateurs")
public String listeProduits(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
Page<animateur> prods = animateurService.getAllAnimateursParPage(page, size);
modelMap.addAttribute("animateurs", prods);
 modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeAnimateurs";
}


@RequestMapping("/supprimerAnimateur")
public String supprimerProduit(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
animateurService.deleteAnimateurById(id);
Page<animateur> prods = animateurService.getAllAnimateursParPage(page, 
size);
modelMap.addAttribute("animateurs", prods);
modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeAnimateurs";
}
@RequestMapping("/supprimerTv")
public String supprimerTv(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
tvService.deleteTvById(id);
List<tv> tvs = tvService.findAll();
modelMap.addAttribute("tvs", tvs);
return "ListeTv";
}

@RequestMapping("/modifierAnimateur")
public String editerAnimateur(@RequestParam("id") Long id,ModelMap modelMap)
{
animateur p= animateurService.getAnimateur(id);
List<tv> tvs = tvService.findAll();
tvs.remove(p.getTv());
modelMap.addAttribute("tvs", tvs);
modelMap.addAttribute("animateurs", p);
modelMap.addAttribute("mode", "edit");
return "formAnimateur";
}
@RequestMapping("/updateAnimateur")
public String updateAnimateur(@ModelAttribute("animateurs") animateur animateur,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateConfirmation = dateformat.parse(String.valueOf(date));
	 animateur.setDateConfirmation(dateConfirmation);
	 
	 animateurService.updateAnimateur(animateur);
	 List<animateur> prods = animateurService.getAllAnimateurs();
	 modelMap.addAttribute("animateurs", prods);
	return "listeAnimateurs";
	}
@RequestMapping("/modifierTv")
public String editerTv(@RequestParam("id") Long id,ModelMap modelMap)
{
tv c= tvService.getTv(id);
modelMap.addAttribute("tvs", c);
modelMap.addAttribute("mode", "edit");
return "formTv";
}
@RequestMapping("/updateTv")
public String updateTv(@ModelAttribute("tv") tv tv,ModelMap modelMap) throws ParseException {
	tvService.updateTv(tv);
	 List<tv> tvs = tvService.findAll();
	 modelMap.addAttribute("tvs", tvs);
	return "ListeTv";
	}
@RequestMapping("/rechercher")
public String rechercher(@RequestParam("nom") String nom,ModelMap modelMap)  {
	
	 List<tv> tvs = tvService.findAll();
	 modelMap.addAttribute("tvs", tvs);
	 List<animateur> prods = animateurService.findByNomAnimateur(nom);
	 modelMap.addAttribute("animateurs", prods);
	 
	return "listeAnimateurs";
	}
@RequestMapping("/saveRole")
public String saveRole(@ModelAttribute("role") Role role,ModelMap modelMap) throws ParseException 
{
	Role saveRole = roleService.saveRole(role);
return "redirect:/ListeUsers";
}
@RequestMapping("/showCreateUser")
public String showCreateUser(ModelMap modelMap)
{
	List<Role> roles = roleService.findAll();
	modelMap.addAttribute("roles", roles);
modelMap.addAttribute("users", new User());
modelMap.addAttribute("mode", "new");
return "FormUser";
}
@RequestMapping("/saveUser")
public String saveUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException 
{
User saveUser = usersService.saveUser(user);
return "redirect:/ListeUsers";
}
@RequestMapping("/ListeUsers")
public String ListeUser(ModelMap modelMap)
{
List <User> users = usersService.findAll();
modelMap.addAttribute("users", users);
return "ListeUsers";
}@RequestMapping("/supprimerUser")
public String supprimerUser(@RequestParam("id") Long id,
		 ModelMap modelMap)
		{ 
		usersService.deleteUserById(id);
		List<User> roles = usersService.findAll();
		modelMap.addAttribute("users", roles);
		return "ListeUsers";
		}
@RequestMapping("/modifierUser")
public String modifierUser(@RequestParam("id") Long id,ModelMap modelMap)
{
User u= usersService.getUser(id);
List<Role> role = roleService.findAll();
modelMap.addAttribute("roles", role);
modelMap.addAttribute("users", u);
modelMap.addAttribute("mode", "edit");
return "FormUser";
}
@RequestMapping("/updateUser")
public String updateUser(@ModelAttribute("user") User user,ModelMap modelMap) throws ParseException {
	usersService.updateUser(user);
	 List<User> roles = usersService.findAll();
	 modelMap.addAttribute("users", roles);
	return "ListeUsers";
	}

}