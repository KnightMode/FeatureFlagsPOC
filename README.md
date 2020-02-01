# FeatureFlagsPOC
[![CircleCI](https://circleci.com/gh/sgbcoder/FeatureFlagsPOC/tree/master.svg?style=svg)](https://circleci.com/gh/sgbcoder/FeatureFlagsPOC/tree/master)

Enable Feature Flags during runtime

The Conventional Way to add feature flags is to add a buildConfigField in the build.gradle and set boolean values to enable/disable the feature.
But in the above approach everytime we need to enable the feature, a new build is needed with the buildConfig value changed.
This becomes troublesome for QA,BA as they may need to approach the Dev to make the necessary code change and give them a new build.
In order to avoid this, the feature flags in the above POC have been added at runtime.

The approach followed here is to have a feature flags screen (before the usual launcher activity for all builds except release)
and allow the user to select the desired feature flags.

Once the user selects the flags, he/she will be unable to go back to the feature flag screen and needs to clear the cache/storage in order to change the build flag.
--
