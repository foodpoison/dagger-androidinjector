/*
 * Copyright 2017 Nimrod Dayan CodePond.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codepond.daggersample.feature

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import javax.inject.Inject

import org.codepond.daggersample.R
import dagger.android.AndroidInjection


class FeatureActivity : AppCompatActivity(), FeatureView {
    companion object {
        val EXTRA_SOME_ID = "some_id"
    }

    @Inject lateinit var presenter: FeaturePresenter

    lateinit var someId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        someId = intent.getStringExtra(EXTRA_SOME_ID)
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.doNothing()
    }

    override fun doNothing() {
    }
}