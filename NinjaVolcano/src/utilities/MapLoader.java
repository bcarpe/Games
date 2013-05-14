package utilities;

import java.io.File;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import modelNV.ObjectNV;
import modelNV.PlatformNV;
import modelNV.WallNV;
import ninjaVolcano.GameState;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import physicsEngine.PhysicsEngine;
import view.View;

public class MapLoader {
	
	protected static NodeList objectNodes;
	protected static NodeList platformNodes;
	protected static NodeList wallNodes;
	
	public static void loadMap(String fileName, PhysicsEngine physicsEngine, View view) {	
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	        Document doc = docBuilder.parse (new File(fileName));
	        
	        // normalize text representation
	        doc.getDocumentElement().normalize();

            loadPlatforms(doc, physicsEngine, view);
            
            loadWalls(doc, physicsEngine, view);
            
            loadObjects(doc, physicsEngine, view);
            
            physicsEngine.setGravity(fetchChildIntByName(doc.getDocumentElement(), "gravity"));
            physicsEngine.setTerminalVelocity(fetchChildIntByName(doc.getDocumentElement(), "terminalVelocity"));
		} catch (SAXParseException err) {
	        System.out.println ("** Parsing error" + ", line " 
	                + err.getLineNumber () + ", uri " + err.getSystemId ());
	           System.out.println(" " + err.getMessage ());

	    } catch (SAXException e) {
		    Exception x = e.getException ();
		    ((x == null) ? e : x).printStackTrace ();
	    } catch (Throwable t) {
	    	t.printStackTrace ();
	    }
	}

	private static void loadObjects(Document doc, PhysicsEngine physicsEngine, View view) {
		LinkedList<ObjectNV> objects = new LinkedList<ObjectNV>();
		
		objectNodes = doc.getElementsByTagName("object");
		for(int i = 0; i < objectNodes.getLength(); i++) {
			Element objectElement = (Element)objectNodes.item(i);
			ObjectNV newObject;
			
			int x = fetchChildIntByName(objectElement, "x"),
				y = fetchChildIntByName(objectElement, "y"),
				width = fetchChildIntByName(objectElement, "width"),
				height = fetchChildIntByName(objectElement, "height"),
				mass = fetchChildIntByName(objectElement, "mass");
			
			if (hasChildElement(objectElement, "player")) {
				GameState.player = new modelNV.PlayerNV(x, y, width, height, mass, null);
				newObject = GameState.player;
				GameState.controller.attachControllable(GameState.player);
			}
			else {
				newObject = new modelNV.ObjectNV(x, y, width, height, mass, null);
			}
			
			objects.add(newObject);
		}
		
		for (ObjectNV object : objects) {
			physicsEngine.addObject(object);
			view.addObject(object.getViewObject());
		}
	}

	private static void loadPlatforms(Document doc, PhysicsEngine physicsEngine, View view) {
		LinkedList<PlatformNV> platforms = new LinkedList<PlatformNV>();
		
		platformNodes = doc.getElementsByTagName("platform");
		for(int i = 0; i < platformNodes.getLength(); i++) {
			Element platformElement = (Element)platformNodes.item(i);
			
			PlatformNV newPlatform;
			int x = fetchChildIntByName(platformElement, "x");
			int y = fetchChildIntByName(platformElement, "y");
			int width = fetchChildIntByName(platformElement, "width");
			
			newPlatform = new PlatformNV(x, y, width);
			if (hasChildElement(platformElement, "victoryPlatform"))
				GameState.victoryPlatform = newPlatform;
			platforms.add(newPlatform);
		}
		
		for (PlatformNV platform : platforms) {
			physicsEngine.addPlatform(platform);
			view.addPlatform(platform.getViewPlatform());
		}
	}

	private static void loadWalls(Document doc, PhysicsEngine physicsEngine, View view) {
		LinkedList<WallNV> walls = new LinkedList<WallNV>();
		
		wallNodes = doc.getElementsByTagName("wall");
		for(int i = 0; i < wallNodes.getLength(); i++) {
			Element wallElement = (Element)wallNodes.item(i);
			
			WallNV newWall;
			newWall = new WallNV(fetchChildIntByName(wallElement, "x"),
					fetchChildIntByName(wallElement, "y"),
					fetchChildIntByName(wallElement, "height"),
					fetchChildStringByName(wallElement, "facing").endsWith("left"));
			walls.add(newWall);
		}
		
		for (WallNV wall : walls) {
			physicsEngine.addWall(wall);
			view.addWall(wall.getViewWall());
		}
	}
	
	private static boolean hasChildElement(Element element, String name) {
		return element.getElementsByTagName(name).getLength() > 0;
	}

	private static int fetchChildIntByName(Element element, String name) {
        NodeList xList = element.getElementsByTagName(name);
        Element xElement = (Element)xList.item(0);
        
        NodeList xTextList = xElement.getChildNodes();
        return Integer.parseInt(((Node)xTextList.item(0)).getNodeValue().trim());
	}

	private static String fetchChildStringByName(Element element, String name) {
        NodeList xList = element.getElementsByTagName(name);
        Element xElement = (Element)xList.item(0);

        NodeList xTextList = xElement.getChildNodes();
        return ((Node)xTextList.item(0)).getNodeValue().trim();
	}
}
