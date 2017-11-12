package $Galactic-Empire-Bots;

import net.dv8tion.jda.*;

public class Main{

    private static JDA c5b2;
    private final String TOKEN = "Mzc5MzYwMzg4NzYxOTExMjk2.DOo7cA.Pl3DTQqBsGy6glkkP5BOTn7TmZI";
    public static void Main(string[] args) {
    
        try {
            c5b2 = new JDABuilder(AccountType.BOT).setToken(TOKEN).buildAsync();
            JDA.addEventListener(new BotListener())
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

public class BotListener extends ListenerAdapter 
{
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        String content = message.getRawContent(); 
        // getRawContent() is an atomic getter
        // getContent() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
    }
}