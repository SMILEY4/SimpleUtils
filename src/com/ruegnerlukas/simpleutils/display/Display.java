package com.ruegnerlukas.simpleutils.display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Display {


	private JFrame frame;
	private JPanel panel;

	private List<DisplayListener> listeners = new ArrayList<DisplayListener>();

	private volatile boolean created = false;




	public Display(DisplayConfig cfg) {

		this.listeners.addAll(cfg.listeners);

		// setup frame
		frame = new JFrame(cfg.title);
		frame.setSize(cfg.width, cfg.height);
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(!cfg.decorated);

		// exit with escape-key
		if (cfg.exitWithEscape) {
			frame.addKeyListener(new KeyListener() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						exit();
					}
				}




				@Override
				public void keyReleased(KeyEvent e) {
				}




				@Override
				public void keyTyped(KeyEvent e) {
				}
			});
		}

		// events on exit
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				exit();
			}
		});


		// setup jpanel
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;




			@Override
			protected void paintComponent(Graphics gr) {
				super.paintComponent(gr);
				if (!created) {
					return;
				}
				for (DisplayListener l : listeners) {
					l.onDraw((Graphics2D) gr, this);
				}
			}
		};
		frame.add(panel);
		frame.setVisible(true);
	}




	public void start() {

		for (DisplayListener l : listeners) {
			l.onCreate();
		}

		created = true;


		while (true) {
			frame.repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}




	public void exit() {
		for (DisplayListener l : listeners) {
			l.onExit();
		}
		System.exit(0);
	}




	public void addListener(DisplayListener listener) {
		this.listeners.add(listener);
	}




	public void removeListener(DisplayListener listener) {
		this.listeners.remove(listener);
	}




	public void addMouseMotionListener(MouseMotionListener listener) {
		this.frame.addMouseMotionListener(listener);
	}




	public void addKeyListener(KeyListener listener) {
		this.frame.addKeyListener(listener);
	}




	public JFrame getFrame() {
		return this.frame;
	}


}
