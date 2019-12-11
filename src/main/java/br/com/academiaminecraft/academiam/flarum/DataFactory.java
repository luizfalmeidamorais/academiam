package br.com.academiaminecraft.academiam.flarum;

import br.com.academiaminecraft.academiam.flarum.event.DiscussionCreateEvent;
import org.greenrobot.eventbus.EventBus;
import top.trumeet.flarumsdk.Flarum;
import top.trumeet.flarumsdk.data.Data;
import top.trumeet.flarumsdk.data.Discussion;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DataFactory {


   private Flarum flarumClient;
   private List<Data> dataList;

   public DataFactory(Flarum flarumClient) {
	  this.flarumClient = flarumClient;

	  dataList = new LinkedList<>();
   }

   public void startTask() {
	  Timer timer = new Timer();

	  timer.schedule(new TimerTask() {
		 @Override
		 public void run() {

		    updateDiscussions();

		 }
	  }, 0, 12000);


   }

   /**
	* Atualiza a lista de discussões do fórum.
	*/
   public void updateDiscussions() {
	  try {
		 List<Discussion> discussions = flarumClient.getDiscussionList()
		   .execute()
		   .mainAttr;

		 for (Discussion discussion : discussions) {
			if (contains(discussion)) continue;

			dataList.add(discussion);
			EventBus.getDefault().post(new DiscussionCreateEvent(discussion));
		 }

	  } catch (Exception e) {
		 e.printStackTrace();
	  }
   }

   private boolean contains(Data data) {
	  return dataList.contains(data);
   }

   public Flarum getFlarumClient() {
	  return flarumClient;
   }
}
