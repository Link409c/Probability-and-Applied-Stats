This program was written as a practical test of the Stats Library Program methods, applying what we have learned so far
to a concept that is interesting and useful for my hobby of the Yu-Gi-Oh card game. A version of this program already
exists and is accessible through a website, but I currently do not know of a app-based alternative. For those of you
reading this who do not play the Yu-Gi-Oh Card game, let me explain some simple concepts that drive the usefulness of
this program. From reading and understanding this, I hope you can gain an interest in one of my favorite hobbies and
appreciate how i've connected its concepts to a fundamental part of my journey toward my Computer Science Degree.

Yu-Gi-Oh (YGO) is a Trading Card Game (TCG) in which you summon monsters, cast spells, and set traps to defeat your opponent.
Each player begins with a five card hand out of a (minimum) forty card deck. The player that goes second is allowed to
draw an additional card for their first turn, and may also attack on their first turn. YGO is a TCG without an overarching
resource system such as Magic the Gathering's mana, or Pokemon's energy. So, the greater part of a turn in modern,
competitive YGO will see players summoning and activating many different cards. Without many costs to use their cards,
it then stands to reason that the more cards you have, the better! So, players want to draw cards from their decks. In
drawing and controlling more cards than your opponent, the player maintains an advantage over them.

Hand advantage is somewhat self explanatory. In most card games, having more cards than your opponent is a good thing.
And in YGO, the more you can draw, theoretically the more you can play. Any card that does this is good, and even better
so based on the restrictions, cost, availability, or other utility the card provides. So, a card such as "Pot of
Extravagance" presents itself as one of the stronger "draw spells" in the game's catalog. The card reads: "At the start
of your Main Phase 1: Banish 3 or 6 random face-down cards from your Extra Deck, face-down; draw 1 card for every 3
cards banished. For the rest of this turn after this card resolves, you cannot draw any cards by card effects." But what
does all this mean? Some card text in YGO is intuitive, and some is unfortunately not. Let's explore why the different
parts of this card are important, and how they relate to programming.

The first part of the card text before the semi-colon is called the cost. This is what must be paid in order to
activate the card. If the cost cannot be paid, the player cannot play the card. So, in order to activate "Pot of
Extravagance", the user chooses a number - three or six. They then randomize the cards in their Extra Deck and pick a
number of them. Thus the cost is paid. But what is an Extra Deck (ED)? The explanation is in the name, but it begs
explaining still. As the name implies, the ED is separate from the Main Deck, which is the group of cards the player is
drawing from. The ED consists of special monsters which may be summoned under specific conditions. Usually, these
cards help the player's strategy or offer them abilities to supplement or cover weaknesses of their strategy. They may
also have effects on the game when removed from the ED. Thus, the ED is an important tool to the player in addition to
their Main Deck.

With the cost of playing Extravagance held in a separate section of the player's available cards, the player is free to
activate it regardless of the state of the rest of their areas of play besides the ED. This gives the card the ability
to swing the game in favor of who plays it, depending on the state of the game. The player also has the choice of how
many cards to draw as a result of using the card, and how to affect the probability of removing key pieces of their ED
as the cost as well. As the card reads, paying the higher cost gives the player one extra card - increasing their total
advantage over their opponent and giving them more tools at their disposal. However, the way the cost is paid, "banished
face-down", is one of the most difficult positions and areas with which a player may try to interact with. When cards
are face-down, they lose all distinguishing characteristics when taken into account by other cards and game mechanics.
The "banished zone" is also less interactive, dependant on the player's suite of effects within their Main Deck. All
of this affects the way the player constructs their ED when playing "Pot of Extravagance", in determining what ratios
of card choices afford them the best probability of keeping key cards in the ED after paying the cost.

The card activation, cost, resolution, and restrictions can all be modeled as steps in a program. Modern YGO cards have
Problem-Solving Card Text (PSCT), a template used to design their readability and understanding into a regular and
somewhat intuitive format. If a card was created without following the format, it would not be released. This can be
likened to the syntax of a programming language. Though there are shortcuts and differences in the way programmers
structure their work, it all can be understood to work similarly toward common results. Cards are read top-to-bottom
and players must execute each step in sequence following the conditions and rules, just like a program. Finally, many
aspects of the card game come together to create a complete experience like classes in a package. Each builds on to the
overall structure and lends its functionality to the result of the complete game. Super and sublclasses exist in cards:
There are cards, and there are Monster, Spell, and Trap cards. All cards have different variables, some mutable and some
immutable. Card types inherit their supertype's attributes but have different ones of their own. Synchro, XYZ (eckseez),
and Link Monsters extend the Monster card class. They all have attack, but some may not have levels or defense. Spells
subclass into Quick-Play, Equip, and Continuous. Traps subclass into Counter Traps. Cards of one type may even become
cards of another type! Many of these concepts have parallels in both worlds.

Returning to the application of this program, the main issue with using the card "Pot of Extravagance" is determining
optimal ratios of cards for your Extra Deck. Players often struggle with determining these ratios in deck building,
even more so because a degree of randomness is involved. Fallacies can take hold when players are biased toward certain
results and face negatives associated with the variance of using the card over time. So, the goal of this program is to
give its users a powerful tool which educates them on probability, and teaches them to value the insight from testing
on customizable and varied data sets rather than smaller observations in limited quantities.