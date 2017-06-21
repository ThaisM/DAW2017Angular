import { NgVisionlynxPage } from './app.po';

describe('ng-visionlynx App', () => {
  let page: NgVisionlynxPage;

  beforeEach(() => {
    page = new NgVisionlynxPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
