package com.example.pasapalabravisual;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable{
    @FXML
    private Label pregunta;
    @FXML
    private TextArea respuesta;
    @FXML
    private ImageView avatar;
    @FXML
    private Button jugar;

    @FXML
    AnchorPane pane;

    Ficheros ficheros = new Ficheros();
    Sistema sistema = new Sistema(ficheros);
    GestorPalabras gestorPalabras = new GestorPalabras();

    private Palabra palabra;
    /*private ObservableList<Node> listaElementosJ1=new ObservableList<Node>() {
        @Override
        public void addListener(ListChangeListener<? super Node> listener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super Node> listener) {

        }

        @Override
        public boolean addAll(Node... elements) {
            return false;
        }

        @Override
        public boolean setAll(Node... elements) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends Node> col) {
            return false;
        }

        @Override
        public boolean removeAll(Node... elements) {
            return false;
        }

        @Override
        public boolean retainAll(Node... elements) {
            return false;
        }

        @Override
        public void remove(int from, int to) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Node> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Node node) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Node> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Node> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Node get(int index) {
            return null;
        }

        @Override
        public Node set(int index, Node element) {
            return null;
        }

        @Override
        public void add(int index, Node element) {

        }

        @Override
        public Node remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Node> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Node> listIterator(int index) {
            return null;
        }

        @Override
        public List<Node> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    }; //Almacena la lista de elementos visuales del jugador
    private ObservableList<Node> listaElementosJ2= new ObservableList<>() {
        @Override
        public void addListener(ListChangeListener<? super Node> listener) {

        }

        @Override
        public void removeListener(ListChangeListener<? super Node> listener) {

        }

        public boolean addAll(Node... elements) {
            return false;
        }


        @Override
        public boolean setAll(Node... elements) {
            return false;
        }

        @Override
        public boolean setAll(Collection<? extends Node> col) {
            return false;
        }

        @Override
        public boolean removeAll(Node... elements) {
            return false;
        }

        @Override
        public boolean retainAll(Node... elements) {
            return false;
        }

        @Override
        public void remove(int from, int to) {

        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Node> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        public boolean add(Node node) {
            return false;
        }


        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        public boolean addAll(Collection<? extends Node> c) {
            return false;
        }

        public boolean addAll(int index, Collection<? extends Node> c) {
            return false;
        }


        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Node get(int index) {
            return null;
        }

        @Override
        public Node set(int index, Node element) {
            return null;
        }

        public void add(int index, Node element) {

        }


        @Override
        public Node remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Node> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Node> listIterator(int index) {
            return null;
        }

        @Override
        public List<Node> subList(int fromIndex, int toIndex) {
            return null;
        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    };*/

    private ArrayList<Node> listaElementosJ1 = new ArrayList<>();
    private ArrayList<Node> listaElementosJ2 = new ArrayList<>();
    public void preguntar() throws IOException {
        jugar.setVisible(false);
        avatar.setVisible(true);
        palabra = gestorPalabras.darDefinicion(sistema.getJugadorActual().getTurno());
        pregunta.setText(palabra.getPregunta());

    }

    public void responder() throws IOException { //LA PREGUNTA VA UN PASO DETRAS DE LA RESPUESTA

        //BOTON PASAPALABRA

        String usuario = respuesta.getParagraphs().toString();
        respuesta.setText("");
        String respuestaUsuario = usuario.substring(1, usuario.length() - 1);
        if (respuestaUsuario.equals("Pasapalabra")) {
            System.out.println(" pasó el turno.");
            sistema.getJugadorActual().aumentarTurno();
            cambiarTurno();
            //EN SISTEMA TIENE QUE GUARDAR LOS DOS JUGADORES QUE EMPIEZAN (MÉTODO EN PASAPALABRA) J1 Y J2
            //TIENE QUE HABER JUGADORACTUAL Y MÉTODO CAMBIAR JUGADOR ACTUAL
        } else if (respuestaUsuario.equals(palabra.getSolucion())) {
            cambiarLetra(sistema.getJugadorActual().getTurno(),true);
            sistema.getJugadorActual().aumentarTurno();
            System.out.println("Respuesta correcta");
        } else {
            cambiarLetra(sistema.getJugadorActual().getTurno(),false);
            sistema.getJugadorActual().aumentarTurno();
            cambiarTurno();
            System.out.println("Respuesta errónea");
        }
        palabra = gestorPalabras.darDefinicion(sistema.getJugadorActual().getTurno());
        pregunta.setText(palabra.getPregunta());
    }

    private void cambiarTurno(){
        sistema.cambiarTurno();
        ObservableList<Node> aa = pane.getChildren();
        if(sistema.getJugadorActual().getNombre()=="Alejandro"){
            listaElementosJ1.clear();
            listaElementosJ1.addAll(pane.getChildren());
            pane.getChildren().clear();
            pane.getChildren().addAll(listaElementosJ2);
            File file = new File("src/main/resources/AvatarMujer.png");
            Image image = new Image(file.toURI().toString());
            avatar.setImage(image);
        }else{
            listaElementosJ2.clear();
            listaElementosJ2.addAll(pane.getChildren());
            /*listaElementosJ2.removeAll();
            for (Node node : pane.getChildren()){
                listaElementosJ2.add(node);
            }*/
            pane.getChildren().clear();
            pane.getChildren().addAll(listaElementosJ1);
            /*pane.getChildren().removeAll();
            for (Node node2 : aa){
                pane.getChildren().add(node2);
            }*/
            File file = new File("src/main/resources/AvatarHombre.png");
            Image image = new Image(file.toURI().toString());
            avatar.setImage(image);
        }
    }

    private void cambiarLetra(int numLetra, Boolean acierto){
        File archivo;
        if(acierto) {
            archivo = new File("src/main/resources/LETRASPASAPALABRA/" + numLetra + "VERDE.png");
        } else{
            archivo = new File("src/main/resources/LETRASPASAPALABRA/" + numLetra + "ROJO.png");
        }
        Image image = new Image(archivo.toURI().toString());
        ImageView imageView = new ImageView(image);
        imageView.setVisible(true);
        imageView.setFitHeight(726);
        imageView.setFitWidth(1323);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setLayoutX(-4);
        pane.getChildren().add(imageView);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* for (Node node : pane.getChildren()){
            listaElementosJ1.add(node);
            listaElementosJ2.add(node);
        }*/
        listaElementosJ1.addAll(pane.getChildren());
        listaElementosJ2.addAll(pane.getChildren());
    }
}