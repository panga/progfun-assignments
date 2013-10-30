package forcomp

object test {
  Anagrams.sentenceAnagrams(List("I","love","you"))
                                                  //> res0: List[forcomp.Anagrams.Sentence] = List(List(Io, Lev, you), List(Io, you
                                                  //| , Lev), List(Lev, Io, you), List(Lev, you, Io), List(you, Io, Lev), List(you,
                                                  //|  Lev, Io), List(you, olive), List(olive, you))
  Anagrams.sentenceAnagrams(List("Yes","man"))    //> res1: List[forcomp.Anagrams.Sentence] = List(List(as, en, my), List(as, my, 
                                                  //| en), List(en, as, my), List(en, my, as), List(my, as, en), List(my, en, as),
                                                  //|  List(my, sane), List(my, Sean), List(man, yes), List(say, men), List(men, s
                                                  //| ay), List(yes, man), List(sane, my), List(Sean, my))
}