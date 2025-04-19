package com.example.ISTE240_Project.config;

import com.example.ISTE240_Project.Models.*;
import com.example.ISTE240_Project.modelsDAO.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final QuoteRepository quoteRepository;
    private final FunFactRepository funFactRepository;
    private final AuthorRepository authorRepository;
    private final NobelRepository nobelRepository;

    @Autowired
    public DataLoader(BookRepository bookRepository,
                      QuoteRepository quoteRepository,
                      FunFactRepository funFactRepository,
                      AuthorRepository authorRepository,
                      NobelRepository nobelRepository) {
        this.bookRepository = bookRepository;
        this.quoteRepository = quoteRepository;
        this.funFactRepository = funFactRepository;
        this.authorRepository = authorRepository;
        this.nobelRepository = nobelRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Quotes
        if (quoteRepository.count() == 0) {
            quoteRepository.saveAll(List.of(
                    new Quote("A reader lives a thousand lives before he dies.", "George R.R. Martin"),
                    new Quote("So many books, so little time.", "Frank Zappa"),
                    new Quote("Until I feared I would lose it, I never loved to read. One does not love breathing.", "Harper Lee"),
                    new Quote("Books are a uniquely portable magic.", "Stephen King"),
                    new Quote("That's the thing about books. They let you travel without moving your feet.", "Jhumpa Lahiri"),
                    new Quote("Reading is essential for those who seek to rise above the ordinary.", "Jim Rohn"),
                    new Quote("A room without books is like a body without a soul.", "Marcus Tullius Cicero")
            ));
        }

        // Fun Facts
        if (funFactRepository.count() == 0) {
            funFactRepository.saveAll(List.of(
                    new FunFact("The first book ever written using a typewriter was 'The Adventures of Tom Sawyer'."),
                    new FunFact("The most expensive book ever purchased was sold for $30.8 million."),
                    new FunFact("Bibliosmia is the enjoyment of the smell of old books."),
                    new FunFact("The longest sentence ever printed is 823 words long, in Victor Hugo's *Les Misérables*."),
                    new FunFact("J.K. Rowling was rejected by 12 publishers before *Harry Potter* was accepted.")
            ));
        }

        // Authors
        if (authorRepository.count() == 0) {
            Author author = new Author(
                    "Han Kang",
                    "Korean",
                    "November 2, 1970",
                    "Seoul, South Korea",
                    "For her uncompromising and compassionate penetration of the human condition.",
                    "Han Kang began her career in 1993 as a poet, but has since written mainly novels and short stories...",
                    "https://www.nobelprize.org/prizes/literature/2024/han/facts/",
                    List.of(
                            new NobelBook("The Vegetarian", "the_vegeterian.jpg"),
                            new NobelBook("Human Acts", "human_acts.jpg"),
                            new NobelBook("The White Book", "the_white_book.jpg"),
                            new NobelBook("We Do Not Part", "we_do_not_part.jpg"),
                            new NobelBook("Greek Lessons", "greek_lessons.jpg")
                    )
            );
            authorRepository.save(author);
            Author author2 = new Author(
                    "Jon Fosse",
                    "Norwegian",
                    "September 29, 1959",
                    "Norway",
                    "For his innovative plays and prose which give voice to the unsayable.",
                    "Jon Fosse's immense œuvre written in Nynorsk consists of a wealth of plays, novels, poetry collections, essays, children’s books and translations. In his radical reduction of language and dramatic action, he expresses the most powerful human emotions of anxiety and powerlessness in the simplest everyday terms. It is through this ability to evoke man’s loss of orientation, that he is a major innovator in contemporary theatre. Despite Fosse's negative outlook, there is great warmth and humour in his work, and a naïve vulnerability to his stark images of human experience.",
                    "https://www.nobelprize.org/prizes/literature/2023/fosse/facts/",
                    List.of(
                            new NobelBook("Melancholy", "melancholy.jpg"),
                            new NobelBook("Morning and Evening", "morning_evening.jpg"),
                            new NobelBook("Trilogy", "trilogy.jpg"),
                            new NobelBook("Weariness", "weariness.jpg"),
                            new NobelBook("Boathouse", "boathouse.jpg")
                    )
            );
            authorRepository.save(author2);
            Author author3 = new Author(
                    "Annie Ernaux",
                    "French",
                    "September 1, 1940",
                    "France",
                    "For the courage and clinical acuity with which she uncovers the roots, estrangements and collective restraints of personal memory.",
                    "In her writing, Annie Ernaux consistently and from different angles, examines a life marked by strong disparities regarding gender, language and class. Her path to authorship was long and arduous. Among her novels are ‘A Man's Place’, ‘A Woman's Story’ and ‘Years’. Ernaux's work is uncompromising and written in plain language, scraped clean. And when she with great courage and clinical acuity reveals the agony of the experience of class, describing shame, humiliation, jealousy or inability to see who you are, she has achieved something admirable and enduring.",
                    "https://www.nobelprize.org/prizes/literature/2022/ernaux/facts/",
                    List.of(
                            new NobelBook("The Years", "the_years.jpg"),
                            new NobelBook("La Place", "la_place.jpg"),
                            new NobelBook("A Woman's Story", "woman.jpg"),
                            new NobelBook("Mémoire De Fille", "fille.jpg"),
                            new NobelBook("Happening", "happening.jpg")
                    )
            );
            authorRepository.save(author3);
            Author author4 = new Author(
                    "Abdulrazak Gurnah",
                    "Tanzanian-British",
                    "December 20, 1948",
                    "England",
                    "For his uncompromising and compassionate penetration of the effects of colonialism and the fate of the refugee in the gulf between cultures and continents.",
                    "The theme of the refugee’s disruption runs throughout Abdulrazak Gurnah's work. He grew up on the island of Zanzibar, but in the 1960s oppression and persecution of citizens of Arab origin forced him to leave the country. Eventually he settled in England. His novels depict a culturally diversified East Africa. Gurnah’s dedication to truth and his aversion to simplification are striking. This can make him bleak and uncompromising, at the same time as he follows the fates of individuals with great compassion and unbending commitment.",
                    "https://www.nobelprize.org/prizes/literature/2021/gurnah/facts/",
                    List.of(
                            new NobelBook("Paradise", "paradise.jpg"),
                            new NobelBook("Afterlives", "afterlives.jpg"),
                            new NobelBook("By the Sea", "sea.jpg"),
                            new NobelBook("Gravel Heart", "Gravel_Heart.jpg"),
                            new NobelBook("Desertion", "Desertion.jpg")
                    )
            );
            authorRepository.save(author4);
            Author author5 = new Author(
                    "Louise Glück",
                    "English",
                    "April 22, 1943",
                    "Cambridge, MA, USA",
                    "For her unmistakable poetic voice that with austere beauty makes individual existence universal.",
                    "Personal experiences have always been an important touchstone for Louise Glück’s poetry. Childhood, family life, relationships and death are recurring themes in her collections. Glück seeks out the universal. Myths and classical motifs are found in most of her work. In addition to classical mythology, the rich English-language poetry tradition is her primary literary source of inspiration. Glück’s language is characterised by clarity and precision and is free of poetic formalities; she often uses daily spoken language.",
                    "https://www.nobelprize.org/prizes/literature/2020/gluck/facts/",
                    List.of(
                            new NobelBook("The Wild Iris", "The_Wild_Iris.jpg"),
                            new NobelBook("Averno", "Averno.jpg"),
                            new NobelBook("Winter Recipes from the Collective", "winter.jpg"),
                            new NobelBook("Faithful and Virtuous Night", "Virtuous.jpg"),
                            new NobelBook("Poems 1962-2012", "poems.jpg")
                    )
            );
            authorRepository.save(author5);
            Author author6 = new Author(
                    "Peter Handke",
                    "English",
                    "December 6, 1942",
                    "Chaville, France",
                    "For an influential work that with linguistic ingenuity has explored the periphery and the specificity of human experience.",
                    "Peter Handke was born in a village named Griffen, located in the Kärnten region in southern Austria. His mother Maria belonged to the Slovenian minority. His father was a German soldier he would not meet before reaching adulthood himself. Instead, he and his siblings grew up with his mother and her new husband. After attending a Christian high school in Klagenfurt he studied law at the University of Graz but broke off his studies a few years later when his debut novel Die Hornissen (1966) was published. Since 1990 he has been based in Chaville, southwest of Paris, from where he has made many productive journeys.",
                    "https://www.nobelprize.org/prizes/literature/2019/handke/facts/",
                    List.of(
                            new NobelBook("A Sorrow Beyond Dreams", "dreams.jpg"),
                            new NobelBook("The Goalie's Anxiety at the Penalty Kick", "kick.jpg"),
                            new NobelBook("Short Letter, Long Farewell", "farewell.jpg"),
                            new NobelBook("The Left-handed woman", "left_handed.jpg"),
                            new NobelBook("The afternoon of a writer", "writer.jpg")
                    )
            );
            authorRepository.save(author6);
            Author author7 = new Author(
                    "Olga Tokarczuk",
                    "Polish",
                    "January 29, 1962",
                    "Wroclaw, Poland",
                    "For a narrative imagination that with encyclopedic passion represents the crossing of boundaries as a form of life.",
                    "Olga Tokarczuk was born in Sulechów in Poland, and lives in Wrocław. Her parents were teachers and her father also functioned as school librarian. In the library she read pretty much everything she could get hold of and it was here that she developed her literary appetite. After studies in psychology at the University of Warsaw she made her debut as a fiction writer 1993 with Podróz ludzi Ksiegi (The Journey of the Book-People). Her real breakthrough came in 1996 with her third novel Prawiek i inne czasy (Primeval and Other Times).",
                    "https://www.nobelprize.org/prizes/literature/2018/tokarczuk/facts/",
                    List.of(
                            new NobelBook("The Empusium", "Empusium.jpg"),
                            new NobelBook("The Lost Soul", "Soul.jpg"),
                            new NobelBook("Primeval and other times", "Primeval.jpg"),
                            new NobelBook("House of Day, House of Night", "house_of_day.jpg"),
                            new NobelBook("Czuły narrator", "narrator.jpg")
                    )
            );
            authorRepository.save(author7);
            Author author8 = new Author(
                    "Kazuo Ishiguro",
                    "Japanese",
                    "November 8, 1954",
                    "Nagasaki, Japan",
                    "Who, in novels of great emotional force, has uncovered the abyss beneath our illusory sense of connection with the world.",
                    "Kazuo Ishiguro was born in Nagasaki, Japan. When he was five, the family moved to Guildford in Surrey, England, where his father, an oceanographer, had been invited to work at a research institute. In his youth Kazuo Ishiguro first wanted to become a musician, but he studied English and philosophy at the University of Kent and then creative writing at the University of East Anglia, where he earned a master’s degree in 1980. Since then he has worked as a writer. Kazuo Ishiguro is married and has a daughter.",
                    "https://www.nobelprize.org/prizes/literature/2017/ishiguro/facts/",
                    List.of(
                            new NobelBook("The Remains of the Day", "day.jpg"),
                            new NobelBook("Klara and the Sun", "klara.jpg"),
                            new NobelBook("The Buried Giant", "giant.jpg"),
                            new NobelBook("The Unconsoled", "unconsoled.jpg"),
                            new NobelBook("A Pale View of Hills", "hills.jpg")
                    )
            );
            authorRepository.save(author8);
            Author author9 = new Author(
                    "Bob Dylan",
                    "English",
                    "May 24, 1941",
                    "Duluth, MN, USA",
                    "For having created new poetic expressions within the great American song tradition.",
                    "Bob Dylan was born in Duluth, Minnesota. His original name was Robert Zimmerman and his grandparents were Jewish immigrants from present-day Ukraine and Lithuania. Already at school he formed several bands. After studying at the University of Minnesota, Minneapolis he moved to New York City in 1961. Since then he has mainly devoted his time to writing and performing lyrics and music. Dylan's lyrics and other writings sometimes reflect his own life, relationships and religious beliefs. He has also worked as a visual artist. Bob Dylan has six children from two marriages.",
                    "https://www.nobelprize.org/prizes/literature/2016/dylan/facts/",
                    List.of(
                            new NobelBook("A Complete Unknown", "unknown.jpg"),
                            new NobelBook("Blowin' In The Wind", "wind.jpg"),
                            new NobelBook("Mr. Tambourine Man", "tambourine.jpg"),
                            new NobelBook("Dont Think Twice, It's All Right", "twice.jpg"),
                            new NobelBook("Like A Rolling Stone", "stone.jpg")
                    )
            );
            authorRepository.save(author9);
            Author author10 = new Author(
                    "Svetlana Alexievich",
                    "Belarusian ",
                    "May 31, 1948",
                    "Belarus",
                    "For her polyphonic writings, a monument to suffering and courage in our time.",
                    "Svetlana Alexievich was born in Ivano Frankivsk, Ukraine. Her father was Belarusian and her mother Ukrainian. Alexievich grew up in Belarus, where both her parents were teachers. She studied to be a journalist at the University of Minsk and worked a teacher, journalist and editor. In Minsk she has worked at the newspaper Sel’skaja Gazeta, Alexievich's criticism of the political regimes in the Soviet Union and thereafter Belarus has periodically forced her to live abroad, for example in Italy, France, Germany and Sweden.",
                    "https://www.nobelprize.org/prizes/literature/2015/alexievich/facts/",
                    List.of(
                            new NobelBook("The Unwomanly Face of War", "face.jpg"),
                            new NobelBook("Last witnesses", "witnesses.jpg"),
                            new NobelBook("Secondhand Time: The Last of the Soviets", "secondhand.jpg"),
                            new NobelBook("Boys in Zinc", "zinc.jpg"),
                            new NobelBook("Zinky Boys", "zinky.jpg")
                    )
            );
            authorRepository.save(author10);
            Author author11 = new Author(
                    "Patrick Modiano",
                    "French",
                    "July 30, 1945",
                    "Paris, France",
                    "For the art of memory with which he has evoked the most ungraspable human destinies and uncovered the life-world of the occupation.",
                    "Patrick Modiano was born in Boulogne-Billancourt outside Paris. His father was a businessman and his mother an actor. They met in Paris during the German occupation during World War II. After growing up with his grandparents and having received Flemish as their first language, Modiano studied at the Lycée Henri IV in Paris and took private lessons in geometry from the writer Raymond Queneau, who came to play a crucial role in the development of Modiano as a writer. He debuted as an author in 1968. Patrick Modiano is married and has two daughters.",
                    "https://www.nobelprize.org/prizes/literature/2014/modiano/facts/",
                    List.of(
                            new NobelBook("Dora Bruder", "Bruder.jpg"),
                            new NobelBook("Rue des Boutiques obscures", "Boutiques.jpg"),
                            new NobelBook("In the Café of Lost Youth", "Café.jpg"),
                            new NobelBook("La Place de l'Étoile", "Étoile.jpg"),
                            new NobelBook("Un Pedigree", "Pedigree.jpg")
                    )
            );
            authorRepository.save(author11);
            Author author12 = new Author(
                    "Alice Munro",
                    "English",
                    "July 10, 1931",
                    "Port Hope, Canada",
                    "Master of the contemporary short story.",
                    "Alice Munro was born in Wingham, Ontario in Canada. Her father was a fox and mink farmer and her mother was a teacher. Munro began writing as a teenager. She also studied at the University of Western Ontario and worked as a library clerk. After marrying she moved with her husband to Dundarave, West Vancouver, and moved again in 1963 to Victoria, where the pair opened a bookstore. Since the late 1960s, Munro dedicated herself to writing.",
                    "https://www.nobelprize.org/prizes/literature/2013/munro/facts/",
                    List.of(
                            new NobelBook("Dear Life", "dear.jpg"),
                            new NobelBook("Lives of Girls and Women", "Girls.jpg"),
                            new NobelBook("Hateship, Friendship, Courtship, Loveship, Marriage", "Courtship.jpg"),
                            new NobelBook("Dance of the Happy Shades", "Shades.jpg"),
                            new NobelBook("The Beggar Maid", "maid.jpg")
                    )
            );
            authorRepository.save(author12);
            Author author13 = new Author(
                    "Mo Yan",
                    "Chinese",
                    "March 25, 1956",
                    "Gaomi, China",
                    "Who with hallucinatory realism merges folk tales, history and the contemporary.",
                    "Mo Yan was born to a farming family in Shandong Province, China. After only a few years of schooling, he began work as a cattle herder at the age of 11. As a young man, Mo Yan enlisted in the army, where his literary talent was first discovered. He published his first novel in 1981 and went on to achieve his international breakthrough with the novel Hong gaoliang jiazu (Red Sorghum), which was later adapted for film. Despite the social criticism contained in his books, in China he is viewed as one of the country's foremost authors. Mo Yan is married and has one daughter.",
                    "https://www.nobelprize.org/prizes/literature/2012/yan/facts/",
                    List.of(
                            new NobelBook("Big Breasts and Wide Hips", "Hips.jpg"),
                            new NobelBook("Red Sorghum", "Sorghum.jpg"),
                            new NobelBook("Life and Death Are Wearing Me Out", "Wearing.jpg"),
                            new NobelBook("Frog", "Frog.jpg"),
                            new NobelBook("Sandalwood Death", "Sandalwood.jpg")
                    )
            );
            authorRepository.save(author13);
            Author author14 = new Author(
                    "Tomas Tranströmer",
                    "Swedish",
                    "April 15, 1931",
                    "Stockholm, Sweden",
                    "Because, through his condensed, translucent images, he gives us fresh access to reality.",
                    "Tomas Tranströmer grew up in Stockholm, where his mother was a teacher. After studying the history of literature and other subjects at Stockholm University College, he studied to become a psychologist. Apart from his authorship, Tranströmer has also worked as a psychologist at the Labour Market Institute in Västerås, Sweden, among other places. Tranströmer suffered a stroke in 1990 that severely limited his ability to speak and that has also influenced his writing. His later poems have taken on a shorter, even more concentrated format as a result. Tranströmer is married with two daughters.",
                    "https://www.nobelprize.org/prizes/literature/2011/transtromer/facts/",
                    List.of(
                            new NobelBook("The Sorrow Gondola", "Gondola.jpg"),
                            new NobelBook("17 Poems", "17.jpg"),
                            new NobelBook("Östersjöar", "Östersjöar.jpg"),
                            new NobelBook("For the Living and the Dead", "living_dead.jpg"),
                            new NobelBook("The Great Enigma", "Enigma.jpg")
                    )
            );
            authorRepository.save(author14);
            Author author15 = new Author(
                    "Mario Vargas Llosa",
                    "Peruvian",
                    "March 28, 1936",
                    "Arequipa, Peru",
                    "For his cartography of structures of power and his trenchant images of the individual's resistance, revolt, and defeat.",
                    "Mario Vargas Llosa was born into a middle-class family in Arequipa, Peru. His parents divorced when he was young, and Vargas Llosa grew up with his mother and maternal grandparents in Bolivia, where his grandfather worked as a consular officer. Vargas Llosa developed an interest in poetry at an early age, which was a source of worry for his father, who enrolled him in a military academy. Nevertheless, he followed his literary instincts and became a writer. Vargas Llosa was also politically active and ran as a candidate in the Peruvian presidential election of 1990. Nowadays he spends most of his time in Madrid, but also lives in Peru. Vargas Llosa is married with three children.",
                    "https://www.nobelprize.org/prizes/literature/2010/vargas_llosa/facts/",
                    List.of(
                            new NobelBook("La Casa Verde", "Verde.jpg"),
                            new NobelBook("The Time of the Hero", "hero.jpg"),
                            new NobelBook("The Bad Girl", "The_Bad_Girl.jpg"),
                            new NobelBook("The Feast of the Goat", "Goat.jpg"),
                            new NobelBook("Los Cachorros", "Cachorros.jpg")
                    )
            );
            authorRepository.save(author15);
            Author author16 = new Author(
                    "Herta Müller",
                    "German",
                    "August 17, 1953",
                    "Germany",
                    "Who, with the concentration of poetry and the frankness of prose, depicts the landscape of the dispossessed.",
                    "Herta Müller was born in a farming family living in Nitchidorf, outside Timisoara, Romania. Her family belonged to Romania's German-speaking minority, whose vulnerable position during the communist regime came to color Müller's life and literary works. Müller was dismissed from her position as a translator after refusing to cooperate with the Securitate secret police, becoming a teacher and author instead. Her debut work, Niederungen (Nadirs), was published in Romania as a censored version in 1982, while uncensored copies were distributed abroad. Müller went into exile in Germany in 1987.",
                    "https://www.nobelprize.org/prizes/literature/2009/muller/facts/",
                    List.of(
                            new NobelBook("The Hunger Angel", "Hunger.jpg"),
                            new NobelBook("The Land of Green Plums", "Plums.jpg"),
                            new NobelBook("Niederungen", "Niederungen.jpg"),
                            new NobelBook("The Fox Was Ever the Hunter", "Fox.jpg"),
                            new NobelBook("The Passport", "Passport.jpg")
                    )
            );
            authorRepository.save(author16);
            Author author17 = new Author(
                    "Jean-Marie Gustave Le Clézio",
                    "French",
                    "April 13, 1940",
                    "France; Mauritius",
                    "Author of new departures, poetic adventure and sensual ecstasy, explorer of a humanity beyond and below the reigning civilization.",
                    "Jean-Marie Gustave le Clézio was born in Nice, France, but grew up on Mauritius, where his relatives had worked as bankers for generations. His father, a doctor, was of British heritage, and his family was bilingual. Le Clézio lived among indigenous peoples in Panama for several years during the 1970s; an experience that fundamentally changed his view of life, art, and people. He has also worked at several universities in different parts of the world. Le Clézio and his wife, Jemia, divide their time between Nice, Mauritius, and Albuquerque, USA.",
                    "https://www.nobelprize.org/prizes/literature/2008/clezio/facts/",
                    List.of(
                            new NobelBook("Le Chercheur d'or", "Chercheur.jpg"),
                            new NobelBook("Le Procès-verbal", "Procès.jpg"),
                            new NobelBook("Mondo et autres histoires", "histoires.jpg"),
                            new NobelBook("The African", "African.jpg"),
                            new NobelBook("Lullaby", "Lullaby.jpg")
                    )
            );
            authorRepository.save(author17);
            Author author18 = new Author(
                    "Doris Lessing",
                    "English",
                    "October 22, 1919",
                    "United Kingdom",
                    "That epicist of the female experience, who with scepticism, fire and visionary power has subjected a divided civilisation to scrutiny.",
                    "Doris Lessing was born in Kermanshah, Persia (now Iran). Her father was a bank clerk and her mother a nurse. Her family later moved to Southern Rhodesia in 1925. Doris Lessing attended a convent school and a girls' school, but ended her studies at age 14 and moved from home. She went on to work as a nursemaid, telephonist, stenographer, and journalist, and published a few short stories. Lessing moved to London in 1949. She became involved in politics and social issues and actively took part in the campaign against nuclear weapons. Doris Lessing was married twice and had three children.",
                    "https://www.nobelprize.org/prizes/literature/2007/lessing/facts/",
                    List.of(
                            new NobelBook("The Golden Notebook", "Notebook.jpg"),
                            new NobelBook("The Fifth Child", "Fifth.jpg"),
                            new NobelBook("Through the Tunnel", "Tunnel.jpg"),
                            new NobelBook("To Room Nineteen", "Nineteen.jpg"),
                            new NobelBook("The Good Terrorist", "Terrorist.jpg")
                    )
            );
            authorRepository.save(author18);
            Author author19 = new Author(
                    "Orhan Pamuk",
                    "Turkish",
                    "June 7, 1952",
                    "Turkey",
                    "Who in the quest for the melancholic soul of his native city has discovered new symbols for the clash and interlacing of cultures.",
                    "Orhan Pamuk grew up in an affluent, secular family in Istanbul . He began studies in architecture, but abandoned his education to become a writer. Orhan Pamuk has been faithful to his hometown, although he periodically has taught at American universities. Pamuk was charged in 2005 with having insulted the Turkish nation’s honor, but the indictment was later dismissed.",
                    "https://www.nobelprize.org/prizes/literature/2006/pamuk/facts/",
                    List.of(
                            new NobelBook("The Museum of Innocence", "Innocence.jpg"),
                            new NobelBook("My Name Is Red", "Red.jpg"),
                            new NobelBook("Snow", "Snow.jpg"),
                            new NobelBook("The Black Book", "Black_Book.jpg"),
                            new NobelBook("The Red-Haired Woman", "Red_Haired.jpg")
                    )
            );
            authorRepository.save(author19);
            Author author20 = new Author(
                    "Harold Pinter",
                    "English",
                    "October 10, 1930",
                    "London, United Kingdom",
                    "Who in his plays uncovers the precipice under everyday prattle and forces entry into oppression's closed rooms.",
                    "Harold Pinter was a British writer, born in London where he lived his whole life. He grew up in a working-class neighborhood in the Hackney district, the son of Jewish immigrants. World War II and the prevailing anti-Semitic sentiment have characterized his writing. Pinter was politically involved in left-wing causes and active in the peace movement.",
                    "https://www.nobelprize.org/prizes/literature/2005/pinter/facts/",
                    List.of(
                            new NobelBook("The Birthday Party", "Birthday.jpg"),
                            new NobelBook("The Caretaker", "Caretaker.jpg"),
                            new NobelBook("Betrayal", "Betrayal.jpg"),
                            new NobelBook("Old Times", "Old_Times.jpg"),
                            new NobelBook("No Man's Land", "Mans_Land.jpg")
                    )
            );
            authorRepository.save(author20);
            Author author21 = new Author(
                    "Elfriede Jelinek",
                    "German",
                    "October 20, 1946",
                    "Austria",
                    "For her musical flow of voices and counter-voices in novels and plays that with extraordinary linguistic zeal reveal the absurdity of society's clichés and their subjugating power.",
                    "Elfriede Jelinek was born in Mürzzuschlag, Austria in 1946. As a child and adolescent she took lessons in piano and organ playing at the conservatory in Vienna. She studied art and theater at university while also completing her musical studies. By then she also had developed an interest in composing texts, which would eventually be her main form of artistic expression. She married in 1974. Because of her social phobia, she was unable to come to Stockholm and receive her Nobel Prize.",
                    "https://www.nobelprize.org/prizes/literature/2004/jelinek/facts/",
                    List.of(
                            new NobelBook("Wonderful, Wonderful Times", "Wonderful.jpg"),
                            new NobelBook("The Piano Teacher", "Piano.jpg"),
                            new NobelBook("Women as Lovers", "Women_as_Lovers.jpg"),
                            new NobelBook("The Children of the Dead", "Dead.jpg"),
                            new NobelBook("Lust", "Lust.jpg")
                    )
            );
            authorRepository.save(author21);
            Author author22 = new Author(
                    "J. M. Coetzee",
                    "English",
                    "February 9, 1940",
                    "South Africa",
                    "Who in innumerable guises portrays the surprising involvement of the outsider",
                    "J.M. Coetzee is a South African author and literary critic who now resides in Australia. During the 1960s he worked as a programmer for IBM in London, which he describes in the semi-autobiographical novel The Young Years. During the 1970s he applied for permanent residence, but was denied it due to his involvement in protests against the Vietnam War. He returned instead to Cape Town, where he taught English literature until 2002.",
                    "https://www.nobelprize.org/prizes/literature/2003/coetzee/facts/",
                    List.of(
                            new NobelBook("The Childhood of Jesus", "Childhood.jpg"),
                            new NobelBook("Disgrace", "Disgrace.jpg"),
                            new NobelBook("Waiting for the Barbarians", "Barbarians.jpg"),
                            new NobelBook("Elizabeth Costello", "Elizabeth_Costello.jpg"),
                            new NobelBook("Life and Times of Michael K", "Michael_K.jpg")
                    )
            );
            authorRepository.save(author22);
            Author author23 = new Author(
                    "Imre Kertész",
                    "Hungarian",
                    "November 9, 1929",
                    "Hungary",
                    "For writing that upholds the fragile experience of the individual against the barbaric arbitrariness of history.",
                    "Imre Kertész was born in Budapest in 1929. He was 14 years old during the Holocaust, when he was taken to the concentration camp in Auschwitz, and later Buchenwald. This trauma is at the heart of Kertész’s writing, and experiences in the camps serve as the basis of both his debut novel Fateless and his later works. He was rescued in 1945 and then returned to Budapest, where he worked as a journalist, a translator of German literature and later as a writer. During the 1990s Kertész moved to Berlin.",
                    "https://www.nobelprize.org/prizes/literature/2002/kertesz/facts/",
                    List.of(
                            new NobelBook("Fateless", "Fateless.jpg"),
                            new NobelBook("Dossier K.", "Dossier.jpg"),
                            new NobelBook("Tasfiye", "Tasfiye.jpg"),
                            new NobelBook("Detective Story", "Detective_Story.jpg"),
                            new NobelBook("The Union Jack", "Union.jpg")
                    )
            );
            authorRepository.save(author23);
            Author author24 = new Author(
                    "V. S. Naipaul",
                    "English",
                    "August 17, 1932",
                    "United Kingdom",
                    "For having united perceptive narrative and incorruptible scrutiny in works that compel us to see the presence of suppressed histories.",
                    "British author V.S. Naipaul was born in Trinidad, with family roots in India. At the age of 18, he left Trinidad for studies in the United Kingdom, where he ended up staying. Naipaul made his debut with the novel The Mysterious Masseur in 1957. Naipaul has devoted much of his life to travel in different places in the world, which has come to be reflected in his novels as well as his travel writing and reportage.",
                    "https://www.nobelprize.org/prizes/literature/2001/naipaul/facts/",
                    List.of(
                            new NobelBook("A House for Mr Biswas", "Biswas.jpg"),
                            new NobelBook("Miguel Street", "Miguel_Street.jpg"),
                            new NobelBook("A Bend in the River", "Tasfiye.jpg"),
                            new NobelBook("An Area of Darkness", "Darkness.jpg"),
                            new NobelBook("The Mimic Men", "Mimic.jpg")
                    )
            );
            authorRepository.save(author24);
        }

        // Nobel Prizes
        if (nobelRepository.count() == 0) {
            nobelRepository.saveAll(List.of(
                    new NobelPrize("Han Kang", 2024, "/images/han_kang.jpg"),
                    new NobelPrize("Jon Fosse", 2023, "/images/jon_fosse.jpg"),
                    new NobelPrize("Annie Ernaux", 2022, "/images/annie_ernaux.jpg"),
                    new NobelPrize("Abdulrazak Gurnah", 2021, "/images/abdulrazak_gurnah.jpg"),
                    new NobelPrize("Louise Glück", 2020, "/images/Louise_Glück.jpg"),
                    new NobelPrize("Peter Handke", 2019, "/images/peter_handke.jpg"),
                    new NobelPrize("Olga Tokarczuk", 2018, "/images/olga_tokarczuk.jpg"),
                    new NobelPrize("Kazuo Ishiguro", 2017, "/images/kazuo_ishiguro.jpg"),
                    new NobelPrize("Bob Dylan", 2016, "/images/bob_dylan.jpg"),
                    new NobelPrize("Svetlana Alexievich", 2015, "/images/svetlana_alexievich.jpg"),
                    new NobelPrize("Patrick Modiano", 2014, "/images/patrick_modiano.jpg"),
                    new NobelPrize("Alice Munro", 2013, "/images/alice_munro.jpg"),
                    new NobelPrize("Mo Yan", 2012, "/images/mo_yan.jpg"),
                    new NobelPrize("Tomas Tranströmer", 2011, "/images/Tomas_Tranströmer.jpg"),
                    new NobelPrize("Mario Vargas Llosa", 2010, "/images/Mario_Vargas_Llosa.jpg"),
                    new NobelPrize("Herta Müller", 2009, "/images/Herta_Müller.jpg"),
                    new NobelPrize("Jean-Marie Gustave Le Clézio", 2008, "/images/Jean-Marie_Gustave_Le_Clézio.jpg"),
                    new NobelPrize("Doris Lessing", 2007, "/images/doris_lessing.jpg"),
                    new NobelPrize("Orhan Pamuk", 2006, "/images/orhan_pamuk.jpg"),
                    new NobelPrize("Harold Pinter", 2005, "/images/harold_pinter.jpg"),
                    new NobelPrize("Elfriede Jelinek", 2004, "/images/elfriede_jelinek.jpg"),
                    new NobelPrize("J. M. Coetzee", 2003, "/images/J_M_Coetzee.jpg"),
                    new NobelPrize("Imre Kertész", 2002, "/images/Imre_Kertész.jpg"),
                    new NobelPrize("V. S. Naipaul", 2001, "/images/V_S_Naipaul.jpg")
            ));
        }
    }
}
