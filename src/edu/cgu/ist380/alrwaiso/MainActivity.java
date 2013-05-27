package edu.cgu.ist380.alrwaiso;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int currentQuestion;
	private int correctQuestion;
	private String [] questions;
	private String [] answers;
	private Button answerButton;
	private Button questionButton;
	private TextView questionView;
	private TextView answerView;
	private EditText answerText;
	private TextView ScoreView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();	
	}
	
	public void init()
	{
				questions = new String[]{"What is the capital of Egypt?",
				"What class are you in right now?",
				"What year is it?",
				"How many chapters are there in the Holy Quran",
				"who is most famous for \"I Have a Dream?\" "};
				answers = new String[]{"Cairo","IST380","2013","114","Martin Luther King"};
				currentQuestion = -1;
				correctQuestion= 0;
				
				answerButton = (Button)findViewById(R.id.AnswerButton);
				questionButton = (Button)findViewById(R.id.QuestionButton);
				questionView = (TextView) findViewById(R.id.QuestionTextView);
				answerView = (TextView) findViewById(R.id.AnswerTextView);
				ScoreView = (TextView) findViewById(R.id.Score);
				
				questionView.setText("Question #1  "+questions[currentQuestion+1]);
				
				answerText = (EditText) findViewById(R.id.AnswerText);
				
				answerButton.setOnClickListener(new OnClickListener(){
					@Override
				public void onClick(View v) {
				checkAnswer();
				}});
				
				
				questionButton.setOnClickListener(new OnClickListener(){
					@Override
				public void onClick(View v) {
				showQuestion();
				}});
				

	}
	
	public void showQuestion()
	{
			currentQuestion++;
			if(currentQuestion == questions.length)
			{
				currentQuestion =0;
				ScoreView.setText("You answered correctley "+correctQuestion+" out of 5 Questions");
				correctQuestion= 0;
			}
			questionView.setText("Question #  "+(currentQuestion+1)+" "+questions[currentQuestion]);
			answerView.setText("");
			answerText.setText("");
	}
	
	public boolean isCorrect(String answer)
	{
		if (currentQuestion==-1)
			currentQuestion=0;
		return (answer.equalsIgnoreCase(answers[currentQuestion]));
	}
	
	public void checkAnswer()
	{
			String answer = answerText.getText().toString();
			if(isCorrect(answer))
			{
				correctQuestion++;
				answerView.setText("You're right!");
				
			}
			else
			answerView.setText("Sorry, the correct answer is "+answers[currentQuestion]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
