package com.example.biologyquizapplication.model;

import java.util.ArrayList;
import java.util.Random;

// This class handles the storage and retrieval of quiz questions
public class QuestionDataAccess {
    private final ArrayList<Question> questions; // Stores all quiz questions
    private final ArrayList<Question> generator; // A copy of questions used for random selection

    // Constructor initializes the question list and generator list
    public QuestionDataAccess() {
        questions = new ArrayList<>(); // Initializes the main question list
        populateList();  // Fills the list with predefined questions

        System.out.println("GENERATOR REACHED");
        generator = new ArrayList<>(questions); // Copies all questions to the generator list
    }

    // This method populates the question list with predefined quiz questions
    private void populateList() {
        // Classification in Biology
        questions.add(new Question("What is the highest taxonomic rank in biological classification?",
                new String[]{"Phylum", "Kingdom", "Domain", "Order"}, 2));
        questions.add(new Question("Which domain includes humans and other animals?",
                new String[]{"Archaea", "Bacteria", "Eukarya", "Prokarya"}, 2));
        questions.add(new Question("What is the scientific name for the classification system introduced by Carl Linnaeus?",
                new String[]{"Binomial", "Taxonomy", "Phylogeny", "Systematics"}, 0));
        questions.add(new Question("What is the correct order of taxonomic ranks from highest to lowest?",
                new String[]{"Domain, Kingdom, Phylum, Class",
                        "Kingdom, Domain, Class, Phylum",
                        "Domain, Kingdom, Class, Phylum",
                        "Domain, Phylum, Kingdom, Class"}, 0));
        questions.add(new Question("Which of the following is not a taxonomic rank?",
                new String[]{"Genus", "Family", "Group", "Species"}, 2));
        questions.add(new Question("What is the primary purpose of biological classification?",
                new String[]{"Grouping by color", "Organizing traits", "Size comparison", "Creating species"}, 1));
        questions.add(new Question("What does 'phylogeny' refer to in biological classification?",
                new String[]{"Traits", "Evolution", "Reproduction", "Adaptation"}, 1));
        questions.add(new Question("Which of the following is a characteristic of organisms in the domain Archaea?",
                new String[]{"Nucleus", "Extremes", "Photosynthesis", "Chloroplasts"}, 1));
        questions.add(new Question("Which taxonomic rank is more specific than 'Family'?",
                new String[]{"Class", "Genus", "Order", "Phylum"}, 1));
        questions.add(new Question("What does a cladogram represent in biological classification?",
                new String[]{"Structure", "Ancestry", "Location", "Mutations"}, 1));
        questions.add(new Question("Which branch of biology focuses on naming and classifying organisms?",
                new String[]{"Genetics", "Ecology", "Taxonomy", "Evolution"}, 2));
        questions.add(new Question("Which kingdom is the most diverse in terms of species?",
                new String[]{"Animalia", "Plantae", "Protista", "Fungi"}, 0));
        questions.add(new Question("What is the smallest unit of classification in taxonomy?",
                new String[]{"Genus", "Species", "Family", "Order"}, 1));
        questions.add(new Question("What is the purpose of binomial nomenclature?",
                new String[]{"Describe anatomy", "Two-part names", "Color grouping", "History"}, 1));
        questions.add(new Question("What is the primary focus of systematics in biology?",
                new String[]{"Classification", "Evolution", "Ecosystems", "Mutations"}, 1));
        questions.add(new Question("What is the role of a dichotomous key in classification?",
                new String[]{"Sequence DNA", "Identify organisms", "Compare habitats", "Classify diseases"}, 1));
        questions.add(new Question("Which domain includes organisms that lack a nucleus?",
                new String[]{"Eukarya", "Archaea", "Bacteria", "Both Archaea and Bacteria"}, 3));
        questions.add(new Question("Which scientist is credited with developing the modern classification system?",
                new String[]{"Darwin", "Mendel", "Linnaeus", "Wallace"}, 2));
        questions.add(new Question("What is the term for organisms that share a common ancestor?",
                new String[]{"Homologous", "Analogous", "Phylogenetic", "Monophyletic"}, 3));
        questions.add(new Question("What is the main difference between a clade and a taxon?",
                new String[]{"Ancestry vs. traits",
                        "Taxon has all organisms",
                        "Clade includes extinct",
                        "Clade is scientific name"}, 0));

// Kingdoms in Biology
        questions.add(new Question("Which kingdom includes multicellular, eukaryotic organisms that are autotrophic?",
                new String[]{"Animalia", "Plantae", "Protista", "Fungi"}, 1));
        questions.add(new Question("Which kingdom contains organisms that are unicellular and prokaryotic?",
                new String[]{"Bacteria", "Fungi", "Plantae", "Animalia"}, 0));
        questions.add(new Question("Which kingdom contains organisms that are decomposers?",
                new String[]{"Fungi", "Animalia", "Plantae", "Protista"}, 0));
        questions.add(new Question("Which kingdom includes multicellular organisms that are heterotrophic?",
                new String[]{"Animalia", "Plantae", "Fungi", "Bacteria"}, 0));
        questions.add(new Question("Which kingdom includes algae and protozoa?",
                new String[]{"Fungi", "Plantae", "Protista", "Bacteria"}, 2));
        questions.add(new Question("Which kingdom includes plants?",
                new String[]{"Animalia", "Plantae", "Fungi", "Protista"}, 1));
        questions.add(new Question("Which kingdom includes yeasts, molds, and mushrooms?",
                new String[]{"Fungi", "Plantae", "Animalia", "Protista"}, 0));
        questions.add(new Question("Which kingdom includes both autotrophic and heterotrophic organisms?",
                new String[]{"Plantae", "Animalia", "Fungi", "Protista"}, 3));
        questions.add(new Question("Which kingdom consists of organisms that can live in extreme environments?",
                new String[]{"Archaea", "Bacteria", "Fungi", "Protista"}, 0));
        questions.add(new Question("Which kingdom includes organisms that are mostly unicellular and live in aquatic environments?",
                new String[]{"Protista", "Fungi", "Plantae", "Animalia"}, 0));

// Sexual Reproduction
        questions.add(new Question("What is the process of fusion of male and female gametes called?",
                new String[]{"Mitosis", "Meiosis", "Fertilization", "Pollination"}, 2));
        questions.add(new Question("Which cell division process produces gametes?",
                new String[]{"Mitosis", "Meiosis", "Fertilization", "Binary fission"}, 1));
        questions.add(new Question("What is the female gamete in humans?",
                new String[]{"Sperm", "Egg", "Pollen", "Ovum"}, 1));
        questions.add(new Question("What is the male gamete in humans?",
                new String[]{"Egg", "Sperm", "Ovum", "Zygote"}, 1));
        questions.add(new Question("What is the term for the fertilized egg in humans?",
                new String[]{"Embryo", "Zygote", "Fetus", "Germ cell"}, 1));
        questions.add(new Question("In sexual reproduction, how many chromosomes are inherited from each parent?",
                new String[]{"23", "46", "12", "92"}, 0));
        questions.add(new Question("What is the term for the joining of two haploid cells?",
                new String[]{"Fertilization", "Mitosis", "Meiosis", "Zygote"}, 0));
        questions.add(new Question("What is the main purpose of sexual reproduction?",
                new String[]{"Growth", "Genetic variation", "Energy production", "Movement"}, 1));
        questions.add(new Question("What is the result of fertilization in humans?",
                new String[]{"Egg", "Zygote", "Sperm", "Embryo"}, 1));
        questions.add(new Question("Which of the following occurs during meiosis?",
                new String[]{"Chromosome number is halved", "Cell divides once", "Genetic material is doubled", "No cell division"}, 0));

// Asexual Reproduction
        questions.add(new Question("What is the process of reproduction that involves only one parent?",
                new String[]{"Sexual reproduction", "Asexual reproduction", "Fertilization", "Mitosis"}, 1));
        questions.add(new Question("What is an example of asexual reproduction?",
                new String[]{"Budding", "Cross-fertilization", "Pollination", "Internal fertilization"}, 0));
        questions.add(new Question("Which of the following organisms reproduces asexually?",
                new String[]{"Human", "Starfish", "Frog", "Yeast"}, 3));
        questions.add(new Question("Which process is used by bacteria for asexual reproduction?",
                new String[]{"Budding", "Binary fission", "Mitosis", "Meiosis"}, 1));
        questions.add(new Question("What is the main advantage of asexual reproduction?",
                new String[]{"Genetic variation", "Faster reproduction", "Requires two parents", "Complex processes"}, 1));
        questions.add(new Question("Which of the following is not a form of asexual reproduction?",
                new String[]{"Budding", "Binary fission", "Fertilization", "Fragmentation"}, 2));
        questions.add(new Question("Which of the following is an example of asexual reproduction in plants?",
                new String[]{"Pollination", "Budding", "Vegetative propagation", "Cross-fertilization"}, 2));
        questions.add(new Question("What is the result of asexual reproduction?",
                new String[]{"Genetic variation", "Clones", "Offspring with two parents", "Genetic recombination"}, 1));
        questions.add(new Question("Which of the following is a form of asexual reproduction in fungi?",
                new String[]{"Budding", "Fertilization", "Spore formation", "Pollination"}, 2));
        questions.add(new Question("Which of the following is a form of asexual reproduction in plants?",
                new String[]{"Vegetative propagation", "Cross-pollination", "Mating", "Conjugation"}, 0));

// Plants
        questions.add(new Question("Which part of the plant absorbs water and minerals?",
                new String[]{"Leaf", "Root", "Stem", "Flower"}, 1));
        questions.add(new Question("Which of the following is not a type of plant tissue?",
                new String[]{"Dermal", "Vascular", "Ground", "Connective"}, 3));
        questions.add(new Question("What is the primary function of the leaf?",
                new String[]{"Photosynthesis", "Reproduction", "Water storage", "Support"}, 0));
        questions.add(new Question("What type of plant reproduction involves flowers?",
                new String[]{"Asexual", "Vegetative", "Sexual", "Spore formation"}, 2));
        questions.add(new Question("What is the male part of a flower called?",
                new String[]{"Stigma", "Pistil", "Anther", "Style"}, 2));
        questions.add(new Question("What is the female part of a flower called?",
                new String[]{"Stigma", "Anther", "Pistil", "Filament"}, 2));
        questions.add(new Question("Which of the following is a characteristic of angiosperms?",
                new String[]{"Seedless", "Naked seeds", "Flowers and fruits", "Non-vascular"}, 2));
        questions.add(new Question("What is the process of pollination?",
                new String[]{"Movement of pollen to stigma", "Growth of seed", "Division of cells", "Absorption of water"}, 0));
        questions.add(new Question("Which part of the plant is responsible for photosynthesis?",
                new String[]{"Stem", "Leaf", "Root", "Flower"}, 1));
        questions.add(new Question("Which of the following is a vascular tissue in plants?",
                new String[]{"Xylem", "Phloem", "Epidermis", "Cortex"}, 0));


    }

    // This method selects a random question from the generator list and removes it after selection
    public Question getRandomQuestion(){
        if (generator == null) return null;  // Safety check to ensure generator is initialized
        if (generator.isEmpty()){ // If all questions have been used, return null
            System.out.println("Generator is EMPTY");
            return null;
        }
        // Selects a random question from the generator list
        Question question = generator.get(new Random().nextInt(generator.size()));
        // Adds the selected question to the list of used questions (tracked in UserAnswersModule)
        UserAnswersModule.usedQuestions.add(question);
        // Removes the selected question from the generator list to prevent repetition
        generator.remove(question);
        return question; // Returns the selected question
    }

}
