PLAY_BIN=~/activator/activator
PLAY_DIR=~/activator/emotion_next
STAGE_DIR=$PLAY_DIR/target/universal/stage
START_BIN=$STAGE_DIR/bin/emotion_next
PID_FILE=$STAGE_DIR/RUNNING_PID
USER=`stat -c '%U' $PLAY_DIR`
PORT='9090'
LISTEN_IP='0.0.0.0'

case $1 in
    start)
      start-stop-daemon --no-close --chuid=$USER:admin --start --background --chdir $PLAY_DIR --exec $START_BIN --pidfile=$PID_FILE -- -Dconfig.file=~/activator/emotion_next/conf/application.conf -Dhttp.address=$LISTEN_IP -Dhttp.port=$PORT > /dev/null
      ;;
esac
