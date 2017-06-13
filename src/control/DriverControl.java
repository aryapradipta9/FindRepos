package control;

import model.DriverModel;
import view.DriverView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TimerTask;
import java.util.Timer;

/**
 * Created by 13515017 / Putu Arya Pradipta.
 * Tanggal 6/13/2017.
 * FileName : DriverControl.java.
 */
public class DriverControl {
  private DriverView driverView;
  private DriverModel driverModel;

  public DriverControl() {
    driverModel = new DriverModel();
    driverView = new DriverView();
    TimerTask timerTask = new TimerTask() {
      @Override
      public void run() {
        driverModel.getRemainingReq().update();
        driverView.getStatusBar().setRepoRequest(driverModel.getRemainingReq().getRepoReq());
        driverView.getStatusBar().setUserRequest(driverModel.getRemainingReq().getUserReq());
      }
    };
    Timer timer = new Timer("MyTimer");
    timer.scheduleAtFixedRate(timerTask, 0, 1000);
    driverView.getUser().update(driverModel.getUserListConn().getUserLists().toArray());
    driverView.getSearchBox().getButton().addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        try {
          driverModel.getUserListConn().setKeyword(URLEncoder.encode(driverView.getSearchBox().getTextContent(),"UTF-8") );
        } catch (UnsupportedEncodingException e1) {
          e1.printStackTrace();
        }
        if (driverView.getSearchFilter().getFollower().isSelected()) {
          driverModel.getUserListConn().setFollower(true);
          driverModel.getUserListConn().setMinFollower(Integer.parseInt(driverView.getSearchFilter().getMinfollower().getText()));
          driverModel.getUserListConn().setMaxFollower(Integer.parseInt(driverView.getSearchFilter().getMaxfollower().getText()));
        } else {
          driverModel.getUserListConn().setFollower(false);
        }
        if (driverView.getSearchFilter().getRepository().isSelected()) {
          driverModel.getUserListConn().setRepoNum(true);
          driverModel.getUserListConn().setMinRepoNum(Integer.parseInt(driverView.getSearchFilter().getMinrepository().getText()));
          driverModel.getUserListConn().setMaxRepoNum(Integer.parseInt(driverView.getSearchFilter().getMaxrepository().getText()));
        } else {
          driverModel.getUserListConn().setRepoNum(false);
        }
        driverModel.getUserListConn().search(driverView.getSearchCriteria().getSelectedid());
        driverView.getUser().update(driverModel.getUserListConn().getUserLists().toArray());
        driverView.getUser().getTable().addMouseListener(new MouseListener() {
          @Override
          public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
              final JTable target = (JTable)e.getSource();
              final int row = target.getSelectedRow();
              final int column = target.getSelectedColumn();
              // Cast to ur Object type
              final String urObjctInCell = (String)target.getValueAt(row, column);

              driverModel.getRepoListConn().setUsername(urObjctInCell);
              driverModel.getRepoListConn().search();
              driverView.getRepo().update(driverModel.getRepoListConn().getRepoList());
            }

          }

          @Override
          public void mousePressed(MouseEvent e) {

          }

          @Override
          public void mouseReleased(MouseEvent e) {

          }

          @Override
          public void mouseEntered(MouseEvent e) {

          }

          @Override
          public void mouseExited(MouseEvent e) {

          }
        });
      }
    });
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new DriverControl();
      }
    });

  }
}
