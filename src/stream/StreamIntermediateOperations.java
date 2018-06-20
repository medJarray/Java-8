package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Cet exemple montre divers extraits de code pour illustrer
 * les opérations intermédiaires sur les Streams.
 * Les opérations intermédiaires renvoient un autre stream
 * qui vous permet d'appeler plusieurs opérations (intermédiaires ou terminal) sous la forme d'une requête.
 */

public class StreamIntermediateOperations {

    public static void main(String args[]){
        /**
         * L'opération stream.filter renvoie un nouveau flux contenant des éléments correspondant à son prédicat.
         * Ci-dessous, nous utiliserons une expression lambda pour créer Predicate qui vérifiera si l'entier est inférieur à Quatre.
         * L'opération stream.count du terminal renverra le nombre d'éléments dans le flux.
         */
        List<Integer> listInteger = Arrays.asList(-4, 0, 1, 2, -6, -11, 3, 5, 10);
        long elementsLessThanFour = listInteger.stream()
                .filter(e -> e < 4)
                .count();
        System.out.println(" --> le nbre des elements inferieur à 4 est \n"+elementsLessThanFour);
        System.out.println("\n --> les elements superieur à zéro sont");
        listInteger.stream()
                .filter(x -> x > 0)
                .forEach(System.out::println);

        /**
         * stream.map va transformer les éléments dans un flux en utilisant une fonction.
         * Une fonction est une méthode qui accepte un argument et produit un résultat.
         * Dans l'extrait ci-dessous, nous allons créer une fonction en utilisant
         * une expression lambda qui remplacera toute chaîne nulle dans le flux avec [inconnu].
         */
        List<String> listString_Map = Arrays.asList("Java", "Spring", null, "JPA", null, "Angular");
        System.out.print("\n --> La resultat après l'opération Map_1\n");
        listString_Map.stream().
                map(s -> {
                    if (s == null) {
                        return s = "[Inconnu]";
                    } else {
                        return s;
                    }
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /**
         * Le stream.peek est extrêmement utile pendant le débogage.
         * Cela vous permet de jeter un coup d'œil dans le flux avant qu'une action ne soit détectée.
         * Dans cet extrait, nous allons filtrer toutes les chaînes d'une taille supérieure à quatre,
         * puis appelez le coup d'oeil sur le flux avant que la carte ne soit appelée.
         * L'opération peek imprimera les éléments de 'avion', 'voiture', 'moto' et 'velo'.
         */
        System.out.print("\n --> Peek \n");
        List<String> listString_Peek = Arrays.asList("avion", "voiture", "moto", "velo");
        listString_Peek.stream()
                .filter(s -> s.length() >= 4)
                .peek(System.out::println)
                .map(s -> s.toUpperCase()).collect(Collectors.toList())
                .forEach(System.out::println);

        /**
         * stream.distinct trouvera des éléments uniques dans un flux en fonction de leur comportement .equals.
         */
        System.out.print("\n --> Distinct \n");
        IntStream.of(1, 3, 5, 1, 2, 2, 2, 56, 56, 7, 8, 9, 7, 10 , 5)
                .distinct()
                .forEach(System.out::println);

        /**
         * La méthode stream.sorted renvoie un flux trié en fonction de l'ordre naturel.
         * Ci-dessous, nous allons créer un flux d'ints puis appeler le tri qui renverra les nombres dans l'ordre croissant.
         */
        System.out.print("\n --> Afficher les nombres dans l'ordre **Croissant**\n");
        IntStream.of(1, 3, 5, 1, 2, 2, 2, 56, 56, 7, 8, 9, 7, 10 , 5)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.print("\n --> Afficher les nombres dans l'ordre **Décroissant** \n");
        Stream.of(1, 3, 5, 1, 2, 2, 2, 56, 56, 7, 8, 9, 7, 10 , 5)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        /**
         * stream.limit est une technique utile pour limiter le nombre ou tronquer les éléments à traiter dans le flux.
         * De la même manière que pour limiter les éléments d'une liste,
         * nous pouvons effectuer le même comportement dans un flux, comme indiqué ci-dessous.
         */
        System.out.print("\n --> Limiter les elements de la liste à trois \n");
        Stream.of("Java", "Spring", "Junit", "Angular", "React")
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
