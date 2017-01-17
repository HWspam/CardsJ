package com.company;

import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    static void Test(){
        String [] hand = new Hand();
        String a = new Card.Suit.CLUBS;
        String b = new Card.Suit.DIAMONDS;
        String c = new Card.Suit.SPADES
        String d = new Card.Suit.HEARTS;
        hand.add["a", "b", "c", "d"];



    }

    static HashSet<Card> createDeck() {
        HashSet<Card> deck = new HashSet<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card a = new Card(suit, rank);
                deck.add(a);
            }
        }
        return deck;
    }

    static boolean isFlush(HashSet<Card> hand) {
        HashSet<Card.Suit> suits = hand.stream()
                .map(card -> {
                    return card.suit;
                })
                .collect(Collectors.toCollection(HashSet::new));
        return suits.size() == 1;
    }

    static boolean isStraightFlush(HashSet<Card> hand) {
        HashSet<Card.Suit> suits = hand.stream()
                .map(card -> {
                    return  card.suit;
                })
                .collect(Collectors.toCollection(HashSet::new));
        HashSet<Card.Rank> ranks = hand.stream()
                .map(card -> {
                    return card.rank;
                })
                .collect(Collectors.toCollection(HashSet::new));
        return suits.size() == 1;
        return ranks.size() == 4;
    }
    static boolean isStraight(HashSet<Card> hand) {
        HashSet<Card.Rank> rank = hand.stream()
                .map(card ->{
                    return card.rank;
                })
                .collect(Collectors.toCollection(HashSet::new));
        int hnd = rank;
        rank.sort(hnd);
        return rank.size() == 1;

    }

    static boolean twoPair(HashSet<Card> hand) {
        HashSet<Card.Rank> rank = hand.stream();
        HashSet<Card.Suit> suit = hand.stream()
                .map(card -> {
                    return card.rank;
                    return card.suit;
                })
                .collect(Collector.ofCollection(HashSet::new));
        if (rank == 2 & suit == 2) {
            System.out.print("2pair");
        }
        else {
            new throw Exception;
        }
        return;


    }

    static boolean fourPair(HashSet<Card> hand) {
        HashSet<Card.Rank> rank = hand.stream()
                .map(card -> {
                    return card.rank;
                })
                .collect(Collectors.toCollection(HashSet::new));
        return rank.size() == 1;
    }





    static HashSet<HashSet<Card>> createHand(HashSet<Card> deck) {
        HashSet<HashSet<Card>> hands = new HashSet<>();
        for (Card a1 : deck) {
            HashSet<Card> deck2 = (HashSet<Card>) deck.clone();
            deck2.remove(a1);
            for (Card a2 : deck2) {
                HashSet<Card> deck3 = (HashSet<Card>) deck2.clone();
                deck3.remove(a2);
                for (Card a3 : deck3) {
                    HashSet<Card> deck4 = (HashSet<Card>) deck3.clone();
                    deck4.remove(a3);
                    for (Card a4 : deck4) {
                        HashSet<Card> hand = new HashSet<>();
                        hand.add(a1);
                        hand.add(a2);
                        hand.add(a3);
                        hand.add(a4);
                        hands.add(hand);
                    }
                }
            }
        }
        return hands;
    }

    public static void main(String[] args) {
        HashSet<Card> deck = createDeck();
        HashSet<HashSet<Card>> hands = createHand(deck);
        hands = hands.stream()
                .filter(Main::isFlush)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hands.size());


    }
}
