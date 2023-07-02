package com.example.fitmobile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;



public class ExerciseRepo {

   // public static final String Chest = "0";
   // public static final String Back = "1";
   // public static final String Core = "2";
   // public static final String Arms = "3";
   // public static final String Legs = "4";


    // Return a JSONArray

    public void getExercisesByGroup(ExecutorService srv, Handler uiHandler, String name){




        List<Exercise> data = new ArrayList<>();

        srv.submit(()->{




            try {




                URL url = new URL("http://10.0.2.2:8080/muscle/groups/" + name);


                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder buffer = new StringBuilder();

                String line = "";

                while ((line = reader.readLine()) != null){
                    buffer.append(line);

                }


                JSONArray arr = new JSONArray(buffer.toString());

                for (int i = 0; i < arr.length(); i++){


                    JSONObject current = arr.getJSONObject(i);
                    JSONObject groupOBJ = current.getJSONObject("muscle");


                    String group = groupOBJ.getString("group");



                    Exercise exercise = new Exercise(
                            current.getString("name"),
                            current.getString("level"),
                            current.getString("explanation"),
                            current.getString("imagePath"),
                            group,
                            current.getString("videoUrl")
                            );

                    data.add(exercise);

                }





            } catch (MalformedURLException e) {
                Log.e("DEV", e.getMessage());
            } catch (IOException e) {
                Log.e("DEV", e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV", e.getMessage());
            }
            Message msg = new Message();
            msg.obj = data;

            uiHandler.sendMessage(msg);

        });



    }

    public void downloadImage(ExecutorService srv, Handler uiHandler, String path){


        srv.submit(()->{


            try {
                URL url = new URL(path);
               // Log.e("DEV","BURADA");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                Bitmap bmp = BitmapFactory.decodeStream(conn.getInputStream());

                Message msg = new Message();
                msg.obj = bmp;
                uiHandler.sendMessage(msg);

            } catch (MalformedURLException e) {
                Log.e("DEV",e.getMessage());
            } catch (IOException e) {
                Log.e("DEV",e.getMessage());
            }


        });


    }

    public void getExerciseByName(ExecutorService srv, Handler uiHandler, String name){



        srv.submit(()->{

            try {
                URL url = new URL("http://10.0.2.2:8080/muscle/exercises/" + name);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder buffer = new StringBuilder();

                String line = "";

                while ((line= reader.readLine())!= null){

                    buffer.append(line);
                }
                JSONArray arr = new JSONArray(buffer.toString());

                JSONObject current = new JSONObject();

                for (int i = 0; i < arr.length(); i++) {

                    current = arr.getJSONObject(i);

                }



                JSONObject groupOBJ = current.getJSONObject("muscle");


                String group = groupOBJ.getString("group");



                Exercise exercise = new Exercise(
                            current.getString("name"),
                            current.getString("explanation"),
                            current.getString("videoUrl"),

                            current.getString("imagePath"),
                            group,
                            current.getString("level")

                );




                Message msg = new Message();

                msg.obj = exercise;

                uiHandler.sendMessage(msg);



            } catch (MalformedURLException e) {
                Log.e("DEV",e.getMessage());
            } catch (IOException e) {
                Log.e("DEV",e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV",e.getMessage());
            }



        });
    }


    public void postComment(ExecutorService srv, Handler handler, String exerciseName, String comment){



        srv.submit(()->{

            try {

                JSONObject obj1 = new JSONObject();
                JSONObject obj2 = new JSONObject();
                JSONObject embed = new JSONObject();
                obj1.put("content",comment);
                obj2.put("name", exerciseName);
                //embed.put("exercise", obj2);
                obj1.put("exercise", obj2);
                URL url = new URL("http://10.0.2.2:8080/comments/post");

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setDoInput(true);
                conn.setDoOutput(true);

                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type","application/JSON");

                BufferedOutputStream writer = new BufferedOutputStream(conn.getOutputStream());

                writer.write(obj1.toString().getBytes());

                writer.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder buffer = new StringBuilder();

                String line = "";

                while((line = reader.readLine())!=null){
                    buffer.append(line);
                }

                handler.sendEmptyMessage(0);



            } catch (MalformedURLException e) {
                Log.e("DEV",e.getMessage());
            } catch (IOException e) {
                Log.e("DEV",e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV",e.getMessage());
            }

        });
    }

    public void commentsByExerciseName(ExecutorService srv, Handler handler, String name){

        List<CommentItem> commentsData = new ArrayList<>();

        srv.submit(()->{

            try {
                URL url = new URL("http://10.0.2.2:8080/comments/exercise/" + name);

                HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line = "";

                StringBuilder builder = new StringBuilder();

                while((line= reader.readLine())!=null){
                    builder.append(line);

                }




                JSONArray arr = new JSONArray(builder.toString());

                for (int i = 0; i < arr.length(); i++){

                    JSONObject comment = arr.getJSONObject(i);
                    commentsData.add(new CommentItem(comment.getString("content")));
                }


            } catch (MalformedURLException e) {
                Log.e("DEV",e.getMessage());
            } catch (IOException e) {
                Log.e("DEV",e.getMessage());
            } catch (JSONException e) {
                Log.e("DEV",e.getMessage());
            }

            Message msg = new Message();
            msg.obj = commentsData;
            handler.sendMessage(msg);


        });




    }



}
