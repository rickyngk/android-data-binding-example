package com.rickyngk.databinding.sample5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rickyngk.databinding.sample5.data.DataManager;
import com.rickyngk.databinding.sample5.data.RestApiListResult;
import com.rickyngk.databinding.sample5.model.Question;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {
    DataManager dataManager;
    private CompositeSubscription compositeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataManager = MyApp.get(this).getAppComponent().dataManager();
        compositeSubscription = new CompositeSubscription();

        getQuestions();

    }

    private void getQuestions() {
        compositeSubscription.add(
                dataManager.getQuestions()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(dataManager.getSubscribeScheduler())
                        .subscribe(new Subscriber<RestApiListResult<Question>>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(RestApiListResult<Question> questionResult) {
                                System.out.println(questionResult.total);
                            }
                        })
        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeSubscription.unsubscribe();
    }


}
