/*
 * Copyright MapStruct Authors.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mapstruct.ap.test.nestedtargetproperties;

import java.util.List;
import javax.annotation.Generated;
import org.mapstruct.ap.test.nestedsourceproperties._target.ChartEntry;
import org.mapstruct.ap.test.nestedsourceproperties.source.Artist;
import org.mapstruct.ap.test.nestedsourceproperties.source.Chart;
import org.mapstruct.ap.test.nestedsourceproperties.source.Label;
import org.mapstruct.ap.test.nestedsourceproperties.source.Song;
import org.mapstruct.ap.test.nestedsourceproperties.source.Studio;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-02-07T21:05:06+0100",
    comments = "version: , compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class ChartEntryToArtistUpdateImpl extends ChartEntryToArtistUpdate {

    @Override
    public void map(ChartEntry chartEntry, Chart chart) {
        if ( chartEntry == null ) {
            return;
        }

        if ( chart.getSong() == null ) {
            chart.setSong( new Song() );
        }
        chartEntryToSong( chartEntry, chart.getSong() );
        if ( chartEntry.getChartName() != null ) {
            chart.setName( chartEntry.getChartName() );
        }
    }

    protected void chartEntryToStudio(ChartEntry chartEntry, Studio mappingTarget) {
        if ( chartEntry == null ) {
            return;
        }

        if ( chartEntry.getRecordedAt() != null ) {
            mappingTarget.setName( chartEntry.getRecordedAt() );
        }
        if ( chartEntry.getCity() != null ) {
            mappingTarget.setCity( chartEntry.getCity() );
        }
    }

    protected void chartEntryToLabel(ChartEntry chartEntry, Label mappingTarget) {
        if ( chartEntry == null ) {
            return;
        }

        if ( mappingTarget.getStudio() == null ) {
            mappingTarget.setStudio( new Studio() );
        }
        chartEntryToStudio( chartEntry, mappingTarget.getStudio() );
    }

    protected void chartEntryToArtist(ChartEntry chartEntry, Artist mappingTarget) {
        if ( chartEntry == null ) {
            return;
        }

        if ( mappingTarget.getLabel() == null ) {
            mappingTarget.setLabel( new Label() );
        }
        chartEntryToLabel( chartEntry, mappingTarget.getLabel() );
        if ( chartEntry.getArtistName() != null ) {
            mappingTarget.setName( chartEntry.getArtistName() );
        }
    }

    protected void chartEntryToSong(ChartEntry chartEntry, Song mappingTarget) {
        if ( chartEntry == null ) {
            return;
        }

        if ( mappingTarget.getArtist() == null ) {
            mappingTarget.setArtist( new Artist() );
        }
        chartEntryToArtist( chartEntry, mappingTarget.getArtist() );
        if ( chartEntry.getSongTitle() != null ) {
            mappingTarget.setTitle( chartEntry.getSongTitle() );
        }
        if ( mappingTarget.getPositions() != null ) {
            List<Integer> list = mapPosition( chartEntry.getPosition() );
            if ( list != null ) {
                mappingTarget.getPositions().clear();
                mappingTarget.getPositions().addAll( list );
            }
        }
        else {
            List<Integer> list = mapPosition( chartEntry.getPosition() );
            if ( list != null ) {
                mappingTarget.setPositions( list );
            }
        }
    }
}
