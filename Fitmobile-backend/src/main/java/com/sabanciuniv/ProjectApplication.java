package com.sabanciuniv;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sabanciuniv.controller.StorageServiceController;
import com.sabanciuniv.model.Comment;
import com.sabanciuniv.model.Exercise;
import com.sabanciuniv.model.FileData;
import com.sabanciuniv.model.Muscle;
import com.sabanciuniv.repo.CommentRepo;
import com.sabanciuniv.repo.ExerciseRepo;
import com.sabanciuniv.repo.FileDataRepository;
import com.sabanciuniv.repo.MuscleRepo;
import com.sabanciuniv.repo.StorageRepository;



@SpringBootApplication//(scanBasePackages={"com.sabanciuniv.repo", "com.sabanciuniv.controller", "com.sabanciuniv.model", "com.sabanciuniv."})
public class ProjectApplication implements CommandLineRunner{

	@Autowired MuscleRepo muscleRepo;
	@Autowired ExerciseRepo exerciseRepo;
	@Autowired CommentRepo commentRepo;
	@Autowired FileDataRepository storeRepo;
	
	public static final Logger logger = LoggerFactory.getLogger(ProjectApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		//SpringApplication.run(StorageServiceController.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		
//		
//		Muscle chest = new Muscle("Chest", "Pectoral muscles (colloquially referred "
//				+ "to as \"pecs\") are the muscles that connect the "
//				+ "front of the human chest with the bones of the upper "
//				+ "arm and shoulder. This region contains four muscles that "
//				+ "provide movements to the upper limbs or ribs.");
//		
//		Muscle back = new Muscle("Back", "The muscles of the back are a group of strong, paired muscles that lie on the posterior aspect of the trunk. "
//				+ "They provide movements of the spine, stability to the trunk, "
//				+ "as well as the coordination between the movements of "
//				+ "the limbs and trunk.");
//		
//		Muscle legs = new Muscle("Legs", "The majority of muscles in the leg are considered long muscles, in that they stretch great distances. "
//				+ "As these muscles contract and relax, they move skeletal bones to create movement of the body. "
//				+ "Smaller muscles help the larger muscles, stabilize joints, "
//				+ "help rotate joints, "
//				+ "and facilitate other fine-tuned movements.");
//		
//		Muscle arms = new Muscle("Arms","Your arms contain many muscles that work together to allow you to perform all sorts of motions and tasks."
//				+ " Each of your arms is composed of your upper arm and forearm. "
//				+ "Your upper arm extends from your shoulder to your elbow. "
//				+ "Your forearm runs from your elbow to your wrist.");
//		
//		Muscle shoulder = new Muscle("Shoulders", "The shoulder has about eight muscles that attach to the scapula, "
//				+ "humerus, and clavicle. These muscles form the outer shape of the shoulder and underarm. "
//				+ "The muscles in the shoulder aid in a wide range of movement and help protect and maintain the main shoulder joint, "
//				+ "known as the glenohumeral joint.");
//		
//		Muscle core = new Muscle("Core", "The core is the group of trunk and hip muscles that surround the spine, abdominal viscera and hip. "
//				+ "Core muscles are essential for proper load balance within the spine, pelvis,"
//				+ " and kinetic chain. They spare the spine from excessive load and "
//				+ "are essential for lad transfer between the upper and lower body.");
//		
//		
//		
//		
//		
//		logger.info("Muscles groups are saved!");
//		
//		
//		logger.info("----------------------------------");
//		logger.info("I am adding chest exercises...");
//		
//		
//		
//		
//		
//		
//		List<Muscle> muscles = new ArrayList<>();
//		
//		muscles.add(chest);muscles.add(back);muscles.add(legs);muscles.add(arms);muscles.add(shoulder);muscles.add(core);
//		
//		muscleRepo.insert(muscles);
//		
//		
//		logger.info("---------------------------------------------");
//		
//		
//		
//		Exercise benchPress = new Exercise("Bench Press", "Lie on a bench, grip a barbell with hands shoulder-width apart, lower the bar to your chest, and press it back up."
//				+ " Suggested set size: 5x5", 
//				"HARD","https://www.youtube.com/watch?v=8W0-3l0ErSE",chest,"http://10.0.2.2:8080/image/benchpress.png");
//		
//		
//		Exercise pushUp = new Exercise("Push Up","Get into a plank position with hands slightly wider than shoulder-width apart, "
//				+ "lower your body until your chest nearly touches the floor, "
//				+ "and push back up. Suggested set size: 5 x Until Failure","MEDIUM","https://www.youtube.com/watch?v=JyCG_5l3XLk",chest
//				, "http://10.0.2.2:8080/image/pushup.png");
//		
//		
//		Exercise cableCrossover = new Exercise("Cable Crossover", "Stand between a cable machine with high pulleys, grab the handles,"
//				+ " and bring your hands together in front of your"
//				+ " chest while keeping a slight bend in the elbows. Suggested set size: 4x12", "EASY", "https://www.youtube.com/watch?v=2E1x1MvR9qo"
//				, chest, "http://10.0.2.2:8080/image/cablecrossover.png");
//		
//		Exercise chestFly = new Exercise("Chest Fly", "Lie on a bench with dumbbells in each hand, extend your arms above your chest, "
//				+ "lower the weights in an arc until you feel a stretch in your chest, "
//				+ "and return to the starting position. Suggested set size: 4x12", "MEDIUM", 
//				"https://www.youtube.com/watch?v=eozdVDA78K0", chest,"http://10.0.2.2:8080/image/dumbbellfly.png");
//		
//		
//		Exercise inclineBench = new Exercise("Incline Bench Press", "Lie on an incline bench, grip a barbell with hands shoulder-width apart,"
//				+ " lower the bar to your chest, and press it back up. Suggested set size: 3x12"
//				, "HARD","https://www.youtube.com/watch?v=SrqOu55lrYU", chest, "http://10.0.2.2:8080/image/inclinebenchpress.png");
//		
//		
//		logger.info("Chest exercises are finished!");
//		logger.info("------------------------------");
//		
//		
//		Exercise latPulldown = new Exercise("Lat Pulldown", "Sit at a lat pulldown machine, grip the bar with hands wider than shoulder-width apart,"
//				+ " and pull the bar down to your chest while keeping your back straight. Suggested set size: 3x12", 
//				"MEDIUM", "https://www.youtube.com/watch?v=CAwf7n6Luuc", back, "http://10.0.2.2:8080/image/latpulldown.png");
//		
//		Exercise backExtension = new Exercise("Back Extension", "Lie face down on a back extension bench, place your feet securely under the footpads,"
//				+ " and lift your upper body until it's in line with your lower body. Suggested set size: 3x12", 
//				"EASY","https://www.youtube.com/watch?v=ph3pddpKzzw", back, "http://10.0.2.2:8080/image/backextension.png");
//		
//		
//		Exercise barbellRow = new Exercise("Barbell Row","Stand with feet shoulder-width apart, "
//				+ "bend at the hips, grip a barbell with an overhand grip, and pull the barbell "
//				+ "towards your torso. Suggested set size: 5x5", "HARD", "https://www.youtube.com/watch?v=9efgcAjQe7E", back,
//				"http://10.0.2.2:8080/image/barbellrow.png");
//		
//		
//		Exercise pullUp = new Exercise("Pull Up", "Hang from a pull-up bar with hands shoulder-width apart, "
//				+ "pull your body up until your chin is above the bar, and lower yourself back down. Suggested set size: 4 x Until Failure",
//				"HARD","https://www.youtube.com/watch?v=eGo4IYlbE5g", back, "http://10.0.2.2:8080/image/pullup.png");
//		
//		Exercise deadlift = new Exercise("Deadlift", "Stand with feet hip-width apart, bend at the hips and knees, grip a barbell with an overhand "
//				+ "or mixed grip, and lift the bar by extending your hips and knees. Suggested set size: 5x5", "HARD", "https://www.youtube.com/watch?v=1VrZ1QLTdUs",
//				back, "http://10.0.2.2:8080/image/deadlift.png");
//		
//		
//		logger.info("Back exercises are finished!");
//		logger.info("------------------------------");
//		
//		
//		Exercise legExtension = new Exercise("Leg Extension", "Sit on a leg extension machine, place your shins under the padded bar, "
//				+ "and extend your legs fully. Suggested set size: 4x12", "EASY", "https://www.youtube.com/watch?v=PQRY75OY2TY",
//				legs, "http://10.0.2.2:8080/image/legextension.png");
//
//		Exercise legCurl = new Exercise("Leg Curl","Lie face down on a leg curl machine, hook your ankles under the padded bar, and "
//				+ "curl your legs towards your buttocks. Suggested set size: 4x12", "MEDIUM",
//				"https://www.youtube.com/watch?v=69_4qE2o-9A",legs, "http://10.0.2.2:8080/image/legcurl.png");
//
//		Exercise calfRaise = new Exercise("Calf Raise", "Stand with feet hip-width apart, either on a raised surface"
//				+ " or flat ground, and raise your heels by pressing down on the balls of your feet. Suggested set size: 4x12", "MEDIUM",
//				"https://www.youtube.com/watch?v=PQRY75OY2TY",legs, "http://10.0.2.2:8080/image/calfraise.png");
//
//		Exercise bulgarianSquat = new Exercise("Bulgarian Squat", "Stand with one foot in front of the other, place the rear foot"
//				+ " on an elevated surface, and squat down while keeping your torso upright. Suggested set size: 3x8", "HARD",
//				"https://www.youtube.com/shorts/uODWo4YqbT8",legs, "http://10.0.2.2:8080/image/bulgariansquat.png");
//
//		Exercise squat = new Exercise("Squat", "Stand with feet shoulder-width apart, bend at the hips and knees, and lower your"
//				+ " body until your thighs are parallel to the floor, then stand back up. Suggested set size: 4x10", "MEDIUM",
//				"https://www.youtube.com/shorts/iZTxa8NJH2g",legs, "http://10.0.2.2:8080/image/squat.png");
//		
//		
//		
//		logger.info("Leg exercises are finished!");
//		logger.info("------------------------------");
//		
//		
//		Exercise bicepCurl= new Exercise("Bicep Curl", "Hold dumbbells with palms facing forward, bend your elbows, and curl "
//				+ "the weights towards your shoulders. Suggested set size 3 x 12", "EASY",
//				"https://www.youtube.com/watch?v=ziVPFOROR3k", arms, "http://10.0.2.2:8080/image/bicepcurl.png");
//
//
//		Exercise tricepsPushdown= new Exercise("Triceps Pushdown", "Stand at a cable machine with a high pulley, grip a straight"
//				+ " or V-bar with palms facing down, and press the bar down by extending your arms. Suggested set size 3 x 12", 
//				"EASY", " https://www.youtube.com/watch?v=2-LAMcpzODU", arms, "http://10.0.2.2:8080/image/tricepspushdown.png");
//
//		logger.info("Arm exercises are finished!");
//		logger.info("------------------------------");
//		
//
//		Exercise shoulderPress= new Exercise("Shoulder Press", "Sit or stand with dumbbells in each hand, position the weights at shoulder"
//				+ " height, and press them overhead until your arms are fully extended. Suggested set size 4 x 12", "MEDIUM", " https://www.youtube.com/watch?v=qEwKCR5JCog",
//				shoulder, "http://10.0.2.2:8080/image/shoulderpress.png");
//
//
//		Exercise arnoldPress= new Exercise("Arnold Press", "Sit or stand with dumbbells in each hand, start with palms facing your chest,"
//				+ " rotate your hands as you press the weights overhead, and reverse the motion as you lower the dumbbells."
//				+ " Suggested set size 4 x 10", "HARD", " https://www.youtube.com/watch?v=6Z15_WdXmVw", shoulder,
//				"http://10.0.2.2:8080/image/arnoldpress.png");
//
//			
//		Exercise sideRaise= new Exercise("Lateral Raise", " Stand with dumbbells in each hand, lift the weights out to the sides with a slight"
//				+ " bend in the elbows, and lower. Suggested set size 4 x 15", "MEDIUM", 
//				" https://www.youtube.com/watch?v=3VcKaXpzqRo", shoulder, "http://10.0.2.2:8080/image/sideraise.png");
//		
//		
//		logger.info("Shoulder exercises are finished!");
//		logger.info("------------------------------");
//		
//		
//		Exercise plank= new Exercise("Plank", "Get into a push-up position, but rest on your forearms instead of your hands. "
//				+ "Keep your body in a straight line from head to toe, and hold this position for as long as possible while"
//				+ " engaging your core muscles."
//				+ " Suggested time: 60 second.", "MEDIUM", "https://www.youtube.com/shorts/v25dawSzRTM",core,
//				"http://10.0.2.2:8080/image/plank.png");
//		
//		
//		Exercise legRaises= new Exercise("Leg Raises", "Lie on your back with your legs extended and hands at your sides or"
//				+ " under your lower back for support. Slowly raise your legs until they are perpendicular to the floor, "
//				+ "then lower them back down without touching the ground. Keep your lower back pressed to the floor throughout the movement."
//				+ " Suggested Time: 30 second.", "EASY", "https://www.youtube.com/watch?v=eztjIDteE5g",core,
//				"http://10.0.2.2:8080/image/legraise.png");
//		
//		
//		
//		
//		Exercise sitUp = new Exercise("Sit-Up", "Lie on your back with your knees bent and feet flat on the floor. "
//				+ "Place your hands behind your head or across your chest. Engage your core muscles and lift your upper body"
//				+ " towards your knees, then slowly lower yourself back down to the starting position. Suggested Time: 60 second.", "MEDIUM",
//				"https://www.youtube.com/watch?v=pCX65Mtc_Kk",core, "http://10.0.2.2:8080/image/situp.png");
//		
//		
//		
//		List<Exercise> exercises = new ArrayList<>();
//		
//		exercises.add(benchPress);
//		exercises.add(pushUp);
//		exercises.add(cableCrossover);
//		exercises.add(chestFly);
//		exercises.add(inclineBench);
//		
//		
//		
//		exercises.add(latPulldown);
//		exercises.add(backExtension);
//		exercises.add(barbellRow);
//		exercises.add(pullUp);
//		exercises.add(deadlift);
//		
//		
//		exercises.add(legExtension);
//		exercises.add(legCurl);
//		exercises.add(calfRaise);
//		exercises.add(bulgarianSquat);
//		exercises.add(squat);
//		
//		
//		exercises.add(bicepCurl);
//		exercises.add(tricepsPushdown);
//		
//		
//		exercises.add(shoulderPress);
//		exercises.add(arnoldPress);
//		exercises.add(sideRaise);
//		
//		
//		exercises.add(plank);
//		exercises.add(legRaises);
//		exercises.add(sitUp);
//		
//		
//		exerciseRepo.insert(exercises);
//		
//		logger.info("All exercises are added!");
//		
//		logger.info("-------------------------------------");
//		
//		
//		
//		List<Comment> comments = new ArrayList<>();
//		
//	
//		Comment comment = new Comment("nice exercise", benchPress);
//		
//		Comment comment2 = new Comment("hurts my shoulder", benchPress);
//		
//		Comment comment3 = new Comment("nice", pushUp);
//		
//		Comment comment4 = new Comment("bad exercise", cableCrossover);
//		
//		Comment comment5 = new Comment("my chest hurts", chestFly);
//		
//		Comment comment6 = new Comment("very hard to do", inclineBench);
//		
//		logger.info("Chest comments finished!");
//		logger.info("-------------------------------------");
//		
//		Comment comment7 = new Comment("my fav move", latPulldown);
//		
//		Comment comment8 = new Comment("good for back", backExtension);
//		
//		Comment comment9 = new Comment("so hard", barbellRow);
//		
//		Comment comment10 = new Comment("improve by time", pullUp);
//		
//		Comment comment11 = new Comment("my back hurt vanished", deadlift);
//		
//		logger.info("Back comments finished!");
//		logger.info("-------------------------------------");
//		
//		Comment comment12 = new Comment("good move", legExtension);
//		
//		Comment comment13 = new Comment("worst exercise for legs", legCurl);
//		
//		Comment comment14 = new Comment("useless", calfRaise);
//		
//		Comment comment15 = new Comment("very hard", bulgarianSquat);
//		
//		Comment comment16 = new Comment("I get stronger", squat);
//		
//		logger.info("Leg comments finished!");
//		logger.info("-------------------------------------");
//		
//		Comment comment17 = new Comment("nice bro", bicepCurl);
//		
//		Comment comment18 = new Comment("best exercise", tricepsPushdown);
//		
//		logger.info("Arm comments finished!");
//		logger.info("-------------------------------------");
//		
//		Comment comment19 = new Comment("I feel my shoulders very well", shoulderPress);
//		
//		Comment comment20 = new Comment("hard exercise", arnoldPress);
//		
//		Comment comment21 = new Comment("I stuck at 12 kg", sideRaise);
//		
//		logger.info("Shoulder comments finished!");
//		logger.info("-------------------------------------");
//		
//		Comment comment22 = new Comment("30 sec feels like 10 min", plank);
//		
//		Comment comment23 = new Comment("hate this move", legRaises);
//		
//		Comment comment24 = new Comment("mike tyson style", sitUp);
//		
//		
//		
//		logger.info("Core comments finished!");
//		logger.info("-------------------------------------");
//		
//		comments.add(comment);
//		comments.add(comment2);
//		comments.add(comment3);
//		comments.add(comment4);
//		comments.add(comment5);
//		comments.add(comment6);
//		comments.add(comment7);
//		comments.add(comment8);
//		comments.add(comment9);
//		comments.add(comment10);
//		comments.add(comment11);
//		comments.add(comment12);
//		comments.add(comment13);
//		comments.add(comment14);
//		comments.add(comment15);
//		comments.add(comment16);
//		comments.add(comment17);
//		comments.add(comment18);
//		comments.add(comment19);
//		comments.add(comment20);
//		comments.add(comment21);
//		comments.add(comment22);
//		comments.add(comment23);
//		comments.add(comment24);
//		
//		
//		commentRepo.insert(comments);
//		
//		
//		
//		
//		
		
		
		
		
		
	}
}


