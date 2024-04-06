# GL partie 2

# petite modifications

* changement dans l'ordre des modifiers d'attributs :
    - ![commit 1](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/c024968a96a31692b07057470d7636e75fd7129d)

* supression de méthode vide et déprecier et d'appels inutile à celles-ci:
    - ![commit 2](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/b5649f991f81baf51d97156d64f51ed0c442c2b4)

* supression du type paramétré de OOSpider :
    - ![commit 3](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/7331df5465d62237eb4c42e5e47db045df14cd18)

* remplacement de != null et .size() > 0 par CollectionUtils.isNotEmpty
    - ![commit 4](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/e5fb83403ca852ba5925f7c9e0d988c49105b34a)
    
* supression d'attribut non utilisé :
    - ![commit 5](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/fbe1b51c77da5e7529cb07463815fd4fabb72d7c)

* supression de spécification de type inutile :
    - ![commit 6](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/0cba90849b987ebf58eb4f1efcd20b06cdaad317)

* supression d'un constructeur vide :
    - ![commit 8](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/8981acd771b4186cb898a731c04d42ce0d05e0dc)

* création d'un constructeur privé dans une classe utilitaire :
    - ![commit 9](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/ff55a2996f3e184dc395ca56f0e66b49004932ab)

* modification du nom d'une variable local pour ne pas être ambigu avec l'attribut du même nom :
    - ![commit 10](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/c2dc70dfa89c81916d528735cee6c6319f440dc9)

* supression du package selenium sur la branche master, le package entier est loin de fonctionner :
    - ![commit 11a](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/21178b3e7e0faac6aca5f7fd77fa16595d954d01)
    - ![commit 11b](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/ce1e57def0b75e12b2309635faf1b353bc9c5193)

* supression d'une exception non throw :
    - ![commit 12](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/02ad47e7e1b0cd56db3130ef0aae303e3b8e3a7f)

* remplacement de add dans un for par un appel a addAll :
    - ![commit 13](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/7da7768ae87c2950e88398e1e89c50017af38046)

* modification d'un == null toujours faux dans un if :
    - ![commit 14](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/7981ddba4ece385d55a47bae82724d51ec58e0dd)

* supression de Sytem.out.println utilisé pour le débogage et laissé en commentaire :
    - ![commit 15](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/24076542badc041f4227136b8031b32b9859ec7c)

* supression d'un cast non nécessaire :
    - ![commit 17](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/4423eef393421f2b34ea154bf24a24bd1762413e)

* supression d'un if toujours Faux :
    - ![commit 18](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/afba23c1718118e80cbf3e98a0a10ee8b55807f7)

* création d'une méthode pour éviter de dupliquer du code :
    - ![commit 19a](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/741fe5c8862f66cc958a46d6775ce2ea5dc5621a)
    - ![commit 19b](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/5021c2ef7c3b3d1c9d98529a2b71d4c3587e065d)




# changement moyen 

* supression d'une des interfaces inutiles (Downloader) : son seul implémenteur à part dans 2 test est une classe abstraite.
  Les déclaration de methode et la documentation a été déplacé dans la classe abstraite, celle-ci a été renommer en Downloader pour être en accord avec ses appels dans les autres classe (qui caster avant leur Downloader spécifique en l'interface Downloader), de même ses classes fille ont été modifié.

    - ![commit 7](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/f867159265d272376ee3ab2ad1cbb9ba7028730d)

* création d'une nouvelle classe pour éviter de la duplication de code :
    - ![commit 20](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/14a34f0a9bfff742a2c64c800bdba5e2ba626c9f)

# grand changement 

* dénestage de la méthode select de SmartContentSelector, la nouvelle classe fonctionne mais mettre une javadoc fait planter la génération de celle-ci sans que je sache pourquoi, les nouvelles méthode n'ont donc pas de documentation :
    - ![commit 16](https://gitlab-etu.fil.univ-lille.fr/renaud.fondeur.etu/gl-modification/-/commit/7f7b55a9d1e4f10c157198af3a645964511d4dfd)


# conclusion

Génie Logiciel permet de prendre conscience de l'importance de bonne pratique commune pour éviter des difficulté au prochain développeur ou soi-même.
La présence de beaucoup "d'erreurs" même petite rende la compréhension du code inutilement plus dur. On finit par reconnaître les erreurs typique du développeur dans tous les fichiers (par exemple les == null dans les if) et si habituer est une étape qui est évitable en ayant des bonnes pratiques, en particulier l'abscences de Javadoc, de noms explicites et de séparations des préoccupations dans les classes les plus compliquées rend la compréhension du code pour quelqu'un qui ne connaît pas le fonctionement détaillé d'un crawler impossible.