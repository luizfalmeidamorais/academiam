package br.com.academiaminecraft.academiam;

import br.com.academiaminecraft.academiam.flarum.DataFactory;
import br.com.academiaminecraft.academiam.flarum.listener.ForumListener;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.greenrobot.eventbus.EventBus;
import top.trumeet.flarumsdk.Flarum;

public class Academia {


   private static final String FORUM_URL = "https://www.academiaminecraft.com.br/public/";

   private static JDA discordBot;

   private static DataFactory dataFactory;


   public static JDA jda;

   //Token, GuildId, ChannelId(Vai enviar pra ca as mensagens de quem criou o pedido, e as reações), CategoryId(Vai criar aqui os canais de quem foi aceito)
   private static String[] botIds = new String[]{
	 "NjUzMDgyODE1OTk0Mzk2Njgz.Xex3tA.HCDyFEM1BLwzBJCKXNa9lRHQ8oc"
   };

   public static void main(String[] args) throws Exception {
	  discordBot = new JDABuilder(AccountType.BOT).setToken(botIds[0]).build();
	  discordBot.addEventListener();
	  discordBot.getPresence().setPresence(Activity.playing("Minecraft"), true);
	  discordBot.addEventListener(); //colocar depois

	  dataFactory = new DataFactory(Flarum.create(FORUM_URL));
	  dataFactory.updateDiscussions();

	  EventBus.getDefault().register(new ForumListener());

   }

   public static DataFactory getDataFactory() {
	  return dataFactory;
   }

   public static JDA getJDA() {
	  return discordBot;
   }

   public static String[] getBotIds() {
	  return botIds;
   }
}
