package use_case_discovery;

import presenter.SearchPresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchAsker implements SearchAskerInputBoundary {
    private SearchAskerOutputBoundary presenter;

    public SearchAsker(SearchAskerOutputBoundary presenter){
        this.presenter = presenter;
    }

    public void generateQuestion(){
        ArrayList<String> question_list = new ArrayList<>();
        // ask about the income
        question_list.add("What is the range of income you are looking for?(in unit of k)"); // 1
        question_list.add("The lower bound is?");//2
        question_list.add("The upper bound is?");//3
        question_list.add("What is the range of age you are looking for?(0-100)");// 4
        question_list.add("What marriage status are you looking for?");//5
        question_list.add("1.Single 2.Divorce 3.Married");//6
        question_list.add("What are the hobbies you want them to have?"); //7
        question_list.add("1.Sport 2.Art 3.Music 4.Game 5.Movie 6.Cook 7.Read");//8
        question_list.add("Which type of relationship are you looking for?");//9
        question_list.add("1.Friend 2.One-Night 3.Long-term 4.Short-term 5.Doesn't Care");//10
        question_list.add("Do you want them to have pet?"); //11
        question_list.add("1.Yes 2.No 3.Doesn't Care");//12

        presenter.displayQuestion(question_list);

    }
}
