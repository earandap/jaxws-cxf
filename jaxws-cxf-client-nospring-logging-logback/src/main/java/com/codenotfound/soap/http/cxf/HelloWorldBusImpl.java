package com.codenotfound.soap.http.cxf;

import java.util.ArrayList;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.CXFBusFactory;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.feature.LoggingFeature;

public class HelloWorldBusImpl {

    private Bus bus;

    public HelloWorldBusImpl() {
        // note: if you create a bus when there is no default bus in effect,
        // that bus will become the default bus
        bus = new CXFBusFactory().createBus();

        addFeatures();
    }

    public Bus getBus() {
        return bus;
    }

    private void addFeatures() {
        ArrayList<Feature> features = new ArrayList<Feature>();

        // create a loggingFeature that will log all received/sent messages
        LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setPrettyLogging(true);
        features.add(loggingFeature);

        // set the features on the CXF bus
        bus.setFeatures(features);
    }
}