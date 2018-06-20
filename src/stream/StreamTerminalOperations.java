package Stream;


import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Cet exemple montre divers extraits de code pour illustrer les opérations terminal de stream.
 * Les opérations terminales produisent un résultat non-stream,
 * tel qu'une valeur primitive, une collection ou aucune valeur.
 * Les opérations de terminal sont généralement précédées d'opérations intermédiaires
 * qui renvoient un autre stream qui permet aux opérations d'être connectées sous la forme d'une requête.
 */
public class StreamTerminalOperations {
    public static void main(String args[]){
        /**
         * La méthode Stream.forEach exécutera une action pour chaque élément du Stream.
         * C'est une façon simplifiée en ligne d'écrire une boucle for.
         * Ci-dessous, nous parcourrons chaque élément et appelerons System.our.println.
         */
        System.out.println(" --> ForEach_1 :\n");
        Stream.of("Java", "Spring", "Junit", "Angular", "React")
                .forEach(System.out::println);
        System.out.println("\n --> ForEach_2 :\n");
        Stream.of("Java", "Spring", "Junit", "Angular", "React")
                .forEach(p -> System.out.println(p));
        /**
         * Dans des exemples similaires, convertir un tableau en liste de tableaux et convertir une collection en tableau,
         * cet extrait convertira un stream en tableau en appelant Stream.toArray
         */
        Object[] streamToTableau = Stream.of(1, 2, 3, 4, 5, 6).
                toArray();
        System.out.println("\n --> Length de Tableau est \n"+streamToTableau.length);

        /**
         * Les opérations Stream.reduce se trouvent généralement dans les opérations statistiques
         * telles que les statistiques récapitulatives longues et combinent les éléments de stream en un en utilisant un BinaryOperator.
         * Dans cet extrait, nous allons trouver la somme de tous les éléments d'un stream.
         */
        System.out.println("\n --> Reduce \n");
        int sum = IntStream.of(5, 5, 10, 2, 6)
                .reduce(0,(a,b) -> a+b);
        int multy = IntStream.of(1, 2, 5, 3)
                .reduce(1, (x,y) -> x*y);
        System.out.println("sum = "+sum+ " | multiply = "+multy+"");

        /**
         * L'opération de terminal Stream.collect convertira le stream dans un autre conteneur tel qu'une liste.
         * Dans l'extrait ci-dessous, nous allons convertir un stream en un ensemble.
         */
        Set<String> stringSet = Stream.of("some", "one", "some", "one")
                .collect(Collectors.toSet());
        System.out.println("\n --> Le size de la Set est \n size = "+stringSet.size()+" | Set = "+stringSet);

        /**
         * Trouver le minimum d'un stream est une autre opération de type statistique qui peut être effectuée en appelant Stream.min.
         * Dans cet extrait, nous créons un IntStream qui est un stream spécialisé pour gérer la primitive int et appeler le min.
         * Trouver le minimum d'un stream est similaire à trouver le minimum d'un tableau ou le minimum d'une liste.
         * ISO Stream.max.
         */
        OptionalInt min = IntStream.of(101, 15, 6, 33, 9, 11, 4)
                .min();
        OptionalInt max = IntStream.of(101, 15, 6, 33, 9, 11, 4)
                .max();
        System.out.println("\n --> Le Min et Max \n min = "+min.getAsInt()+" | max = "+max.getAsInt());

        /**
         * Stream.count trouvera le nombre d'éléments dans le stream.
         * Le comptage du nombre d'éléments dans un stream présente des similitudes avec le comptage des occurrences dans une liste,
         * le comptage des chaînes non vides dans une collection et le comptage des mots dans le fichier.
         */
        long nbrElement = Stream.of("Java", "Spring", "Anagular", "Hibernate", "A4C", "TypeScript")
                .count();
        long nbrElementAvecFiltre = Stream.of("Java", "Spring", "Anagular", "Hibernate", "A4C", "TypeScript")
                .filter(s -> s.length() > 4)
                .count();
        System.out.println("\n --> comptage du nombre d'éléments \n nbrElement = "+nbrElement+" | nbrElementAvecFiltre = "+nbrElementAvecFiltre);

        /**
         * Stream.anyMatch découvrira si au moins un des éléments du stream correspond à un prédicat donné.
         * Dans cet extrait, nous allons créer un prédicat à partir d'une expression lambda pour vérifier si la longueur d'une chaîne est supérieure à 5.
         * Stream.allMatch verifier tout les elemntes de stream
         */
        boolean isLessThanTowCarateres = Stream.of("Java", "Spring", "Anagular", "Hibernate", "A4C", "TypeScript")
                .anyMatch(s -> s.length() < 2);
        boolean isAllGreatThanTowCarateres = Stream.of("Java", "Spring", "Anagular", "Hibernate", "A4C", "TypeScript")
                .allMatch(s -> s.length() > 2);
        boolean isAllGreatThanFiveCarateres = Stream.of("Java", "Spring", "Anagular", "Hibernate", "A4C", "TypeScript")
                .allMatch(s -> s.length() > 5);
        System.out.println("\n --> anyMatch + allMatch \n isLessThanTowCarateres : "+isLessThanTowCarateres+" | isAllGreatThanTowCarateres : "+isAllGreatThanTowCarateres+" | isAllGreatThanFiveCarateres : "+isAllGreatThanFiveCarateres);

        /**
         * Stream.findFirst trouvera le premier élément dans le stream qui ressemble
         * au même comportement que l'obtention du premier élément dans une liste.
         */
        Optional<String> firstElement = Stream.of("Java", "Spring", "Anagular", "Hibernate", "A4C", "TypeScript")
                .findFirst();
        System.out.println("\n --> le premier element de stream \n firstElement : "+firstElement.get());
    }
}

