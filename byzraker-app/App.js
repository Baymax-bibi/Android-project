import OneSignal from 'react-native-onesignal';

import React from 'react';
import Share from 'react-native-share';
import SplashScreen from 'react-native-splash-screen';
import {WebView} from 'react-native-webview';
import Problem from './problem.png';
import NetInfo from '@react-native-community/netinfo';
import Header from './header';
import Footer from './footer';
import {
  View,
  ActivityIndicator,
  Text,
  Button,
  Image,
  TouchableOpacity,
  AsyncStorage,
  Modal,
  Alert,
  Linking,
  BackHandler,
  Platform,
} from 'react-native';
/* import RNFetchBlob from 'rn-fetch-blob'; */

/* var RNFS = require('react-native-fs'); */
import Geolocation from 'react-native-geolocation-service';
/* import BottomModal, {ModalContent} from 'react-native-modals';
import StaticServer from 'react-native-static-server'; */
import {PermissionsAndroid} from 'react-native';
/* import {zip, unzip, unzipAssets, subscribe} from 'react-native-zip-archive'; */
import axios from 'axios';
import Backbutton from './back-button.png';

class MainApp extends React.Component {
  constructor(properties) {
    super(properties);

    let requiresConsent = false;

    this.state = {
      showProfile: false,
      isLoggedIn: false,
      showHeader: false,
      requirePrivacyConsent: requiresConsent,
      renderedOnce: false,
      feedtitle: false,
      visible: false,
      loading: false,
      downloading: false,
      error: false,
      updated: false,
      urlloading: true,
      modalToShow: false,
      firstTimeOpen: false,
      navigateToNotification: false,
      id: false,
      tokenexist: false,
      sendtokenexist: false,
      location: '',
      sendlocation: false,
      notification: false,
      showbackbutton: false,
      urltoshow: false,
      canGoBack: false,
      location: 'http://localhost:3000/',
      shouldGoBack: false,
      willGoBack: false,
      title: 'Home',
      navigationUrl: '/',
      makeTransition: false,
      navigationLoading: false,
      login: false,
      logout: false,
    };
    let directory = false;

    // On Android, use "RNFS.DocumentDirectoryPath" (MainBundlePath is not defined)

    //OneSignal.setRequiresUserPrivacyConsent(requiresConsent);
    OneSignal.init('d29eec76-52f0-4490-b2bb-21422ce86efe', {
      kOSSettingsKeyAutoPrompt: true,
    });

    OneSignal.setLogLevel(6, 0);
    //this.getLocationPermission();
    //  this.startServer();
    setTimeout(() => {
      SplashScreen.hide();
    }, 3000);
  }

  shareLink(url, message) {
    Share.open({url, message})
      .then(res => {
        console.log(res);
      })
      .catch(err => {
        err && console.log(err);
      });
  }

  /*  async updateBuild() {
    try {
      console.log('updating build');
      // await RNFS.unlink(`${RNFS.DocumentDirectoryPath}/build.zip`);

      let res = await RNFetchBlob.config({
        // add this option that makes response data to be stored as a file,
        // this is much more performant.
        fileCache: true,
      }).fetch('GET', 'https://nationalflightops.com/uploads/build.zip');
      console.log('path', res.path());
      console.log('file downloaded');

      //console.log('before copy', buildFilesBefore);
      await unzip(res.path(), `${RNFS.DocumentDirectoryPath}/www/`);

      let versionFromServer = await axios.get(
        'http://nationalflightops.com/getupdate.php',
      );
      await AsyncStorage.setItem(
        'version',
        versionFromServer.data.isUpdate.toString(),
      );
    } catch (err) {
      console.log(err);
    }
  } */
  /* 
  async showUpdateDialog() {
    try {
      console.log('going to download');
      this.setState({downloading: true});
      await this.updateBuild();
      this.setState({downloading: false, visible: false});
    } catch (err) {
      console.log(err);
    }
  } */

  /*  async checkForUpdate() {
    try {
      console.log('checking for update');
      let versionFromServer = await axios.get(
        'http://nationalflightops.com/getupdate.php',
      );
      console.log(versionFromServer.data);
      let version = await AsyncStorage.getItem('version');
      if (version) {
        console.log('version found');
        if (versionFromServer.data.isUpdate.toString() > version.toString()) {
          console.log('showing modal');
          this.setState({modalToShow: true});
        } else {
          console.log('upto date');
        }
      } else {
        console.log('version not found');
        this.setState({firstTimeOpen: true});
      }
    } catch (err) {
      console.log(err);
    }
  }
 */
  /*  async startServer() {
    try {
      // await RNFS.unlink(`${RNFS.DocumentDirectoryPath}/www/`);
      let exists = await RNFS.exists(`${RNFS.DocumentDirectoryPath}/www/`);
      console.log('inside start server');
      if (exists) {
        console.log('file exist');
        let files = await RNFS.readdir(
          `${RNFS.DocumentDirectoryPath}/www/build/static/js`,
        );
        let file = await RNFS.readFile(
          `${RNFS.DocumentDirectoryPath}/www/build/index.html`,
          'utf8',
        );
        let index = file.indexOf('<head>');
        let start = file.slice(0, index + 6);
        let end = file.slice(index + 6);
        let fileToWrite = `${start}<script>window.chunkURL="http://localhost/data/build/"</script>${end}`;
        await RNFS.writeFile(
          `${RNFS.DocumentDirectoryPath}/www/build/index.html`,
          fileToWrite,
          'utf8',
        );
        console.log(start);
        console.log(end);
        console.log(file);
        console.log(fileToWrite);
        this.setState({loading: false});
        this.checkForUpdate();
      } else {
        console.log('file not exist');
        await RNFS.mkdir(`${RNFS.DocumentDirectoryPath}/www/`);
        //let assets = await RNFS.readDirAssets('/res');
        await RNFS.copyFileAssets(
          'build/build.zip',
          `${RNFS.DocumentDirectoryPath}/build.zip`,
        );
        let buildFiles = await RNFS.readdir(`${RNFS.DocumentDirectoryPath}`);
        console.log('not Exist', buildFiles);

        await unzip(
          `${RNFS.DocumentDirectoryPath}/build.zip`,
          `${RNFS.DocumentDirectoryPath}/www/`,
        );
        this.setState({loading: false});
        this.checkForUpdate();
      }
    } catch (err) {
      console.log('AN errror occure', err);
    }
  }
 */
  async getLocationPermission() {
    try {
      let canAccessLocation = false;
      const hasPermission = await PermissionsAndroid.check(
        PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION,
      );
      console.log('haspermission', hasPermission);
      if (!hasPermission) {
        const granted = await PermissionsAndroid.request(
          PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION,
          {
            title: 'Cool Photo App Camera Permission',
            message:
              'Cool Photo App needs access to your camera ' +
              'so you can take awesome pictures.',
            buttonNeutral: 'Ask Me Later',
            buttonNegative: 'Cancel',
            buttonPositive: 'OK',
          },
        );
        if (granted === PermissionsAndroid.RESULTS.GRANTED) {
          canAccessLocation = true;
        } else {
          this.setState({
            location: false,
            sendlocation: true,
          });
        }
      } else {
        canAccessLocation = true;
      }
      if (canAccessLocation) {
        Geolocation.getCurrentPosition(
          position => {
            console.log('position', position);
            axios
              .get(
                `https://www.mapquestapi.com/geocoding/v1/reverse?key=CQHkMsBnxMZsth601EAdD5sTpdYTK3ll&location=${position.coords.latitude},${position.coords.longitude}&includeRoadMetadata=true&includeNearestIntersection=true`,
              )
              .then(res => {
                let location = `${res.data.results[0].locations[0].adminArea5}, ${res.data.results[0].locations[0].adminArea3}, ${res.data.results[0].locations[0].adminArea1}`;
                console.log(location);
                this.setState({
                  location: location,
                  sendlocation: true,
                });
              })
              .catch(err => {
                this.setState({
                  location: false,
                  sendlocation: true,
                });
                console.log(err);
              });
          },
          error => {
            // See error code charts below.

            this.setState({
              location: false,
              sendlocation: true,
            });
          },
          {enableHighAccuracy: true, timeout: 15000, maximumAge: 10000},
        );
      }
    } catch (err) {
      console.warn(err);
    }
  }

  CheckConnectivity = () => {
    // For Android devices
    NetInfo.fetch().then(state => {
      console.log('Connection type', state.type);
      if (state.isConnected) {
        this.setState({error: false});
      } else {
        this.setState({error: true});
      }
    });
  };
  async componentDidMount() {
    let isLoggedIn = await AsyncStorage.getItem('isLoggedIn');
    let tempuser = await AsyncStorage.getItem('tempuser');
    console.log(isLoggedIn, 'isLoggein');
    console.log(tempuser, 'tempuer');
    if (isLoggedIn == 'true') {
      this.setState({isLoggedIn: true});
    } else {
      this.setState({isLoggedIn: false});
    }

    if (isLoggedIn == 'true' || tempuser == 'true')
      this.setState({showHeader: true});
    else this.setState({showHeader: false});
    this.backHandler = BackHandler.addEventListener(
      'hardwareBackPress',
      this.handleBackPress,
    );
    console.log('before inking');
    await this.CheckConnectivity();
    Linking.getInitialURL()
      .then(url => {
        if (url) {
          console.log('Initial url is: ' + url);
        }
      })
      .catch(err => console.error('An error occurred', err));
    console.log('after linking');
    //SplashScreen.hide();
    //await this.getLocationPermission();
    var providedConsent = await OneSignal.userProvidedPrivacyConsent();
    await OneSignal.setEmail('rahulkumar12kkp@gmail.com');
    this.onReceived = this.onReceived.bind(this);
    this.onOpened = this.onOpened.bind(this);
    this.onIds = this.onIds.bind(this);

    OneSignal.addEventListener('received', this.onReceived);
    OneSignal.addEventListener('opened', this.onOpened);
    OneSignal.addEventListener('ids', this.onIds);
  }

  componentWillUnmount() {
    OneSignal.removeEventListener('received', this.onReceived);
    OneSignal.removeEventListener('opened', this.onOpened);
    OneSignal.removeEventListener('ids', this.onIds);
    this.backHandler.remove();
  }
  handleTransition = (title, url) => {
    this.setState({
      title,
      navigationUrl: url,
      makeTransition: true,
      navigationLoading: true,
    });
  };

  onReceived(notification) {
    this.setState({
      jsonDebugText: 'RECEIVED: \n' + JSON.stringify(notification, null, 2),
    });
  }

  handleBackPress = () => {
    console.log(this.state.location == 'http://localhost:3000/');
    console.log(this.state.location);
    console.log('shouldgoback', this.state.shouldGoBack);
    /* if (this.state.shouldGoBack) {
      this.setState({willGoBack: true});
      return true;
    } */
    if (this.state.location != 'http://localhost:3000/') {
      console.log('going back');
      //this.webref.goBack();
      this.setState({willGoBack: true});
      return true;
    }
    return false;
  };
  onOpened(openResult) {
    this.setState({
      notification: openResult.notification.payload.additionalData.en,
      navigateToNotification: true,
      shouldGoBack: true,
    });
  }

  onIds(device) {
    this.setState({id: device.userId});
    axios
      .get(
        `https://api.buzzraker.com/savepushtoken?pushtoken=${device.userId}`,
        {
          pushtoken: device.userId,
        },
      )
      .then(res => {
        console.log('push data', res.data);
        if (res.data == 'True' || res.data == true) {
          console.log('setting tue');
          this.setState({tokenexist: true});
        } else {
          console.log('setting false');
          this.setState({tokenexist: false});
        }
      })

      .catch(err => console.log(err));
  }

  hideSpinner() {
    this.setState({visible: false});
  }

  updateSource = () => {
    this.setState({renderedOnce: true});
  };
  disableNotification() {
    console.log('disable notification', this.state.id);
    axios
      .get(
        `https://api.buzzraker.com/disablepushtoken?pushtoken=${this.state.id}`,
      )
      .then(res => {
        this.setState({tokenexist: false});
      })
      .catch(err => console.log(err));
  }
  enableNotification() {
    console.log('enable notification', this.state.id);
    axios
      .get(
        `https://api.buzzraker.com/enablepushtoken?pushtoken=${this.state.id}`,
      )
      .then(res => {
        this.setState({tokenexist: true});
      })
      .catch(err => console.log(err));
  }

  render() {
    if (this.state.loading) {
      return <ActivityIndicator />;
    }
    if (this.state.error) {
      return (
        <Errorscreen
          reload={() => {
            this.CheckConnectivity();
          }}
        />
      );
    }
    if (this.state.willGoBack) {
      console.log('will go back and going back');
      console.log('location', this.state.location);
      let run = `
      var event = new CustomEvent('goback', {detail:"/"});
      document.dispatchEvent(event);
      true;
    `;
      if (this.webref) this.webref.injectJavaScript(run);
      this.setState({shouldGoBack: false, willGoBack: false});
    }
    if (this.state.showProfile) {
      console.log('will go back and going back');
      console.log('location', this.state.location);
      let run = `
      var event = new CustomEvent('profile', {detail:"/"});
      document.dispatchEvent(event);
      true;
    `;
      if (this.webref) this.webref.injectJavaScript(run);
      this.setState({showProfile: false});
    }
    if (this.state.login) {
      console.log('will go back and going back');
      console.log('location', this.state.location);
      let run = `
      var event = new CustomEvent('login', {detail:"/"});
      document.dispatchEvent(event);
      true;
    `;
      if (this.webref) this.webref.injectJavaScript(run);
      this.setState({login: false});
    }
    if (this.state.logout) {
      console.log('will go back and going back');
      console.log('location', this.state.location);
      let run = `
      var event = new CustomEvent('logout', {detail:"/"});
      document.dispatchEvent(event);
      true;
    `;
      if (this.webref) this.webref.injectJavaScript(run);
      this.setState({logout: false});
    }
    if (this.state.makeTransition) {
      console.log('transisting');
      console.log('location', this.state.navigationUrl);
      let run = `
      var event = new CustomEvent('navigate', {detail:"${this.state.navigationUrl}"});
      document.dispatchEvent(event);
      true;
    `;
      if (this.webref) this.webref.injectJavaScript(run);
      this.setState({makeTransition: false});
    }
    if (this.state.navigateToNotification) {
      if (this.state.notification) {
        let run = `
        var event = new CustomEvent('check', {detail:"${this.state.notification}"});
        document.dispatchEvent(event);
        true;
      `;
        if (this.webref) this.webref.injectJavaScript(run);
      }

      this.setState({navigateToNotification: false, notification: false});
    }
    if (this.state.sendtokenexist) {
      let run = `
      var event = new CustomEvent('checktoken', {detail:"${this.state.tokenexist}"});
      document.dispatchEvent(event);
      true;
    `;
      if (this.webref) this.webref.injectJavaScript(run);
      this.setState({sendtokenexist: false});
    }
    if (this.state.sendlocation) {
      let run = `
      var event = new CustomEvent('location', {detail:"${this.state.location}"});
      document.dispatchEvent(event);
      true;
    `;
      if (this.webref) this.webref.injectJavaScript(run);
      this.setState({sendlocation: false});
    }
    return (
      <View style={{flex: 1}}>
        {this.state.showHeader ? (
          <Header
            setProfile={() => this.setState({showProfile: true})}
            title={this.state.title}
            handleTransition={this.handleTransition}
            handleBackPress={this.handleBackPress}
            isLoggedIn={this.state.isLoggedIn}
            setLogin={() => this.setState({login: true, showHeader: false})}
            setLogout={() => this.setState({logout: true, showHeader: false})}
          />
        ) : null}
        <View style={{flex: 1}}>
          <WebView
            onHttpError={syntheticEvent => {
              const {nativeEvent} = syntheticEvent;
              this.setState({error: true});
              console.warn(
                'http  error WebView received error status code: ',
                nativeEvent.statusCode,
              );
            }}
            onLoadEnd={syntheticEvent => {
              // update component to be aware of loading status

              this.setState({error: false});
            }}
            onError={syntheticEvent => {
              const {nativeEvent} = syntheticEvent;
              console.warn('WebView error: ', nativeEvent);
              this.setState({error: true});
            }}
            onNavigationStateChange={navState => {
              console.log(navState);

              if (
                navState.url.indexOf('cnn') >= 0 ||
                navState.url.indexOf('espn') >= 0 ||
                navState.url.indexOf('fox') >= 0 ||
                navState.url.indexOf('twitter') >= 0
              ) {
                if (!this.state.showbackbutton) {
                  this.setState({
                    showbackbutton: true,
                    urltoshow: navState.url,
                    canGoBack: navState.canGoBack,
                  });
                }
              } else {
                this.setState({
                  showbackbutton: false,
                  urltoshow: false,
                  canGoBack: navState.canGoBack,
                });
              }
              // Keep track of going back navigation within component
              this.canGoBack = navState.canGoBack;
            }}
            nativeConfig={{props: {webContentsDebuggingEnabled: true}}}
            ref={r => (this.webref = r)}
            onMessage={event => {
              let data = event.nativeEvent.data.split(':');
              console.log(data);
              if (data[0] == 'url')
                this.shareLink(`https://buzzraker.com${data[1]}`, data[2]);
              if (data[0] == 'tokenexist') {
                this.setState({sendtokenexist: true});
              }
              if (data[0] == 'setTempuser') {
                if (data[1] == 'true') {
                  AsyncStorage.setItem('tempuser', 'true');
                  this.setState({showHeader: true});
                } else {
                  this.setState({showHeader: false});
                  AsyncStorage.setItem('tempuser', 'false');
                }
              }
              if (data[0] == 'setLoggedIn') {
                if (data[1] == 'true') {
                  console.log('setting loggedin true');
                  this.setState({
                    showHeader: true,
                    isLoggedIn: true,
                  });
                  AsyncStorage.setItem('isLoggedIn', 'true');
                } else {
                  this.setState({
                    showHeader: false,
                    isLoggedIn: false,
                  });
                  console.log('setting login false');
                  AsyncStorage.setItem('isLoggedIn', 'false');
                }
              }
              if (data[0] == 'componentReady') {
                this.setState({navigationLoading: false});
              }
              if (data[0] == 'enableepush') {
                this.enableNotification();
              }
              if (data[0] == 'disablepush') {
                this.disableNotification();
              }
              if (data[0] == 'getLocation') {
                this.getLocationPermission();
              }
              if (data[0] == 'getNotification') {
                this.setState({navigateToNotification: true});
              }
              if (data[0] == 'showmodal') {
                this.setState({
                  showbackbutton: true,
                  urltoshow: `${data[1]}:${data[2]}`,
                });
              }
              if (data[0] == 'setLocation') {
                console.log('setlocation', data);
                let newData = `${data[1]}:${data.splice(2).join('')}`;
                console.log('nwdata', newData);
                this.setState({location: newData}, () =>
                  console.log(this.state.location),
                );
              }
            }}
            onShouldStartLoadWithRequest={request => {
              // Only allow navigating within this website
              console.log('req', request);
            }}
            allowFileAccess={true}
            originWhitelist={['*']}
            allowFileAccessFromFileURLs={true}
            allowUniversalAccessFromFileURLs={true}
            userAgent="buzzrakerapp"
            allowFileAccess={true}
            source={{
              uri: `http://localhost:3000`,
            }}
          />

          {this.state.navigationLoading && <LoadingModal />}
          <Modal
            animationType="slide"
            transparent={false}
            visible={this.state.showbackbutton}
            onRequestClose={() => {
              this.setState({showbackbutton: false});
            }}>
            <View style={{flex: 1}}>
              <View
                style={{
                  padding: 15,
                  backgroundColor: '#ddd',
                  flexDirection: 'row',
                }}>
                <TouchableOpacity
                  onPress={() => {
                    this.setState({showbackbutton: false, url: false});
                  }}>
                  <View
                    style={{
                      borderRightWidth: 1,
                      borderRightColor: '#000',
                      paddingRight: 10,
                    }}>
                    <Image source={Backbutton} />
                  </View>
                </TouchableOpacity>
                <View style={{flex: 1, paddingLeft: 10}}>
                  <Text>{this.state.urltoshow}</Text>
                </View>
              </View>
              <View style={{flex: 1}}>
                <WebView
                  originWhitelist={['*']}
                  source={{uri: this.state.urltoshow}}
                />
              </View>
            </View>
          </Modal>
        </View>
        {this.state.showHeader ? (
          <Footer handleTransition={this.handleTransition} />
        ) : null}
      </View>
    );
  }
}

export default MainApp;
/* file://${RNFS.DocumentDirectoryPath}/www/build/index.html */

function Errorscreen(props) {
  return (
    <View
      style={{
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'violet',
      }}>
      <View
        style={{
          flexDirection: 'column',
          justifyContent: 'center',
          alignItems: 'center',
        }}>
        <Image source={Problem} />
        <Text style={{padding: 16, color: 'white', fontSize: 18}}>
          You don't appear to have an internet Connection
        </Text>
      </View>
      <View style={{width: 200, marginTop: 20}}>
        <Button onPress={props.reload} color="#ccc" title="Retry" />
      </View>
    </View>
  );
}

function LoadingModal(props) {
  return (
    <Modal animationType="slide" transparent={false} visible={true}>
      <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
        <ActivityIndicator />
      </View>
    </Modal>
  );
}
