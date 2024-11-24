package com.example.composebasics.data

import com.example.composebasics.R

object DummyData {

    fun getDummyAlignBodyData(): ArrayList<AlignBodyItem> {
        return arrayListOf<AlignBodyItem>().apply {
            this.add(AlignBodyItem(R.drawable.ab1_inversions, R.string.ab1_inversions))
            this.add(AlignBodyItem(R.drawable.ab2_quick_yoga, R.string.ab2_quick_yoga))
            this.add(AlignBodyItem(R.drawable.ab3_stretching, R.string.ab3_stretching))
            this.add(AlignBodyItem(R.drawable.ab4_tabata, R.string.ab4_tabata))
            this.add(AlignBodyItem(R.drawable.ab5_hiit, R.string.ab5_hiit))
            this.add(AlignBodyItem(R.drawable.ab6_pre_natal_yoga, R.string.ab6_pre_natal_yoga))
        }
    }

    fun getDummyFavouritesData(): ArrayList<AlignBodyItem> {
        return arrayListOf<AlignBodyItem>().apply {
            this.add(AlignBodyItem(R.drawable.fc1_short_mantras, R.string.fc1_short_mantras))
            this.add(AlignBodyItem(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations))
            this.add(AlignBodyItem(R.drawable.fc3_stress_and_anxiety, R.string.fc3_stress_and_anxiety))
            this.add(AlignBodyItem(R.drawable.fc4_self_massage, R.string.fc4_self_massage))
            this.add(AlignBodyItem(R.drawable.fc5_overwhelmed, R.string.fc5_overwhelmed))
            this.add(AlignBodyItem(R.drawable.fc6_nightly_wind_down, R.string.fc6_nightly_wind_down))
        }
    }

}
