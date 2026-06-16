import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class chatbot extends JFrame implements ActionListener {

    private JTextArea chatArea;
    private JTextField inputField;
    private final Random rng = new Random();
    private final Map<String, String[]> responses = new HashMap<>();

    public chatbot() {
        setTitle("CoreAlpha Chatbot");
        setSize(520, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        buildResponses();

        JLabel header = new JLabel("Java Assistant", JLabel.LEFT);
        header.setFont(new Font("SansSerif", Font.BOLD, 15));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(60, 120, 200));
        header.setOpaque(true);
        header.setBorder(BorderFactory.createEmptyBorder(12, 14, 12, 14));
        add(header, BorderLayout.NORTH);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        chatArea.setBackground(new Color(245, 246, 250));
        chatArea.setMargin(new Insets(12, 12, 12, 12));
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout(6, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        inputField = new JTextField();
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputField.addActionListener(this);

        JButton sendBtn = new JButton("Send");
        sendBtn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        sendBtn.setPreferredSize(new Dimension(75, 30));
        sendBtn.addActionListener(this);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendBtn, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        appendBot("Hiii! Welcome to CoreAlpha!");
        appendBot("I am your Java learning buddy. You can ask me about:");
        appendBot("  - Java basics\n  - OOP concepts\n  - Classes and Interfaces\n  - Inheritance\n  - Exceptions and Error handling");
        appendBot("So... what are we learning today?");

        setVisible(true);
    }

    private void buildResponses() {
        responses.put("greeting", new String[]{
            "Heyy! Great to see you! What Java topic shall we tackle today?",
            "Hi hi! What is on your mind? Ask me anything about Java!",
            "Hey there! Ready to learn something new? What would you like to know?"
        });
        responses.put("java", new String[]{
            "Ooh Java! Great choice. It is a class-based language that runs on the JVM — write once, run anywhere! What part do you want to explore?",
            "Java is super powerful — handles memory with garbage collection, strongly typed, and used everywhere from Android to big backend systems. Anything specific?",
            "Great topic! Java has been around since 1995 and is still one of the most popular languages. Want to dive into a specific feature?"
        });
        responses.put("oop", new String[]{
            "OOP has four pillars:\n  1. Encapsulation — hide data inside classes\n  2. Inheritance — share behaviour between classes\n  3. Polymorphism — same method, different behaviour\n  4. Abstraction — hide complex details\nWhich one do you want to dig into?",
            "Think of OOP like real life — a Car is an object with properties (speed, colour) and actions (drive, brake). Which concept trips you up?",
            "OOP makes code organised and reusable! Want me to explain any of the four pillars in detail?"
        });
        responses.put("exception", new String[]{
            "Exceptions are Java's way of handling surprises!\ntry { risky code }\ncatch(Exception e) { handle it }\nfinally { always runs }\nWant an example?",
            "Think of try-catch as a safety net — if something goes wrong, Java jumps to catch instead of crashing the whole program!",
            "Checked exceptions (like IOException) must be handled. Unchecked ones (like NullPointerException) are optional to catch."
        });
        responses.put("class", new String[]{
            "A class is like a blueprint — you define the structure once, then create as many objects as you want using 'new'. What aspect do you want to know?",
            "Think of a class like a cookie cutter — the class is the cutter, objects are the cookies! Each cookie has the same shape but can have different values.",
            "Classes have fields (data) and methods (behaviour). A Dog class might have a name field and a bark() method. Simple but powerful!"
        });
        responses.put("interface", new String[]{
            "An interface is a contract — it says WHAT a class must do, but not HOW. The implementing class decides that!",
            "Interfaces are like job descriptions — 'You must be able to fly()' — how you fly is up to you! Great for polymorphism.",
            "With interfaces, you can have one type but many behaviours. Super useful for writing flexible code!"
        });
        responses.put("inheritance", new String[]{
            "Inheritance is the 'is-a' relationship — a Cat IS-A Animal, so Cat can extend Animal and get all its behaviour for free, then add its own!",
            "Use 'extends' to inherit from a parent class — the child gets all parent fields and methods, and can override them too!",
            "Inheritance means code reuse! Why write the same code twice when the child class can just inherit from the parent?"
        });
        responses.put("help", new String[]{
            "Here is what I know:\n  - Java basics\n  - OOP concepts\n  - Classes and objects\n  - Interfaces\n  - Inheritance\n  - Exceptions\nJust ask naturally!",
            "Happy to help! You can ask me about Java, OOP, classes, interfaces, inheritance, or exceptions. What are you working on?",
            "Topics I cover: Java fundamentals, OOP pillars, try-catch, classes, interfaces, and inheritance. Fire away!"
        });
        responses.put("bye", new String[]{
            "Goodbye! Happy coding! Come back anytime.",
            "See you later! Keep practising Java — you are doing great!",
            "Bye bye! Remember: every expert was once a beginner. Keep going!"
        });
        responses.put("thanks", new String[]{
            "You are welcome! Anything else you would like to know?",
            "Happy to help! Got more questions?",
            "Anytime! Keep the questions coming!"
        });
        responses.put("fallback", new String[]{
            "Hmm, I did not quite get that. Could you rephrase? Or type 'help' to see what I can talk about!",
            "That is a bit outside what I know right now. Try 'help' to see my topics!",
            "Not sure about that one! I am best with Java and OOP topics. Type 'help' for a list!"
        });
    }

    public void actionPerformed(ActionEvent e) {
        String text = inputField.getText().trim();
        if (text.isEmpty()) return;
        appendUser(text);
        inputField.setText("");
        appendBot(analyse(text));
    }

    private void appendUser(String text) {
        chatArea.append("You:  " + text + "\n\n");
        scrollDown();
    }

    private void appendBot(String text) {
        chatArea.append("Bot:  " + text + "\n\n");
        scrollDown();
    }

    private void scrollDown() {
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    private String analyse(String raw) {
        String s = raw.toLowerCase().replaceAll("[^a-z0-9 ]", "").trim();
        if (s.isEmpty()) return pick("fallback");

        if (s.matches("(hi|hey|hello|yo|howdy|sup|hiya|hii|heyyy)( .*)?")) return pick("greeting");
        if (s.contains("bye") || s.contains("goodbye") || s.contains("see you")) return pick("bye");
        if (s.contains("thank") || s.contains("thanks") || s.contains("thx"))    return pick("thanks");

        if (s.contains("oop") || s.contains("object") || s.contains("pillar")
                || s.contains("encapsul") || s.contains("polymorphi") || s.contains("abstract"))
            return pick("oop");
        if (s.contains("exception") || s.contains("try") || s.contains("catch")
                || s.contains("throw") || s.contains("finally") || s.contains("error"))
            return pick("exception");
        if (s.contains("inherit") || s.contains("extends") || s.contains("subclass")
                || s.contains("parent") || s.contains("child"))
            return pick("inheritance");
        if (s.contains("interface") || s.contains("implement") || s.contains("contract"))
            return pick("interface");
        if (s.contains("class") || s.contains("blueprint") || s.contains("method")
                || s.contains("field") || s.contains("instance"))
            return pick("class");
        if (s.contains("java") || s.contains("jvm") || s.contains("bytecode"))
            return pick("java");
        if (s.contains("help") || s.contains("what") || s.contains("topics") || s.contains("know"))
            return pick("help");

        return pick("fallback");
    }

    private String pick(String key) {
        String[] opts = responses.getOrDefault(key, responses.get("fallback"));
        return opts[rng.nextInt(opts.length)];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(chatbot::new);
    }
}
