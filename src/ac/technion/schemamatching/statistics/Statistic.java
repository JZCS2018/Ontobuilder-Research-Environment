/**
 * 
 */
package ac.technion.schemamatching.statistics;

import java.util.ArrayList;

import com.modica.ontology.match.MatchInformation;

/**
 * @author Tomer Sagi
 *
 */
public interface Statistic 
{
	public String[] getHeader();
	public String getName();
	public ArrayList<String[]> getData();
	public boolean init(String instanceDescription,MatchInformation mi);
}